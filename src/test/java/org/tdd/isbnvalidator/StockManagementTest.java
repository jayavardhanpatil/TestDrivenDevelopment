package org.tdd.isbnvalidator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by jayavardhanpatil on 10/18/19
 */
public class StockManagementTest {

    @Test
    public void testCorrectLocatorCode(){

        ExternalISBNDataService testWebService = mock(ExternalISBNDataService.class);
        when(testWebService.lookup(anyString())).thenReturn(new Book("0984782869", "Cracking the Coding Interview", "Gayle Laakmann McDowell"));

        ExternalISBNDataService testDataBaseService = mock(ExternalISBNDataService.class);
        when(testDataBaseService.lookup(anyString())).thenReturn(null);

        StockManger stockManager = new StockManger();
        stockManager.setWebService(testWebService);
        stockManager.setDataBaseService(testDataBaseService);
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("2869G4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0984782869")).thenReturn(new Book("0984782869","abc","abc"));

        StockManger stockManager = new StockManger();
        stockManager.setWebService(webService);
        stockManager.setDataBaseService(databaseService);
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService).lookup("0984782869");
        verify(webService, never()).lookup(anyString());

    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0984782869")).thenReturn(null);
        when(webService.lookup("0984782869")).thenReturn(new Book("0984782869","abc","abc"));

        StockManger stockManager = new StockManger();
        stockManager.setWebService(webService);
        stockManager.setDataBaseService(databaseService);
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService).lookup("0984782869");
        verify(webService).lookup("0984782869");
    }

}
