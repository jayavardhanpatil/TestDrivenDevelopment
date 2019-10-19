package org.tdd.isbnvalidator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by jayavardhanpatil on 10/18/19
 */
public class StockManagementTest {


    ExternalISBNDataService testWebService;
    ExternalISBNDataService testDataBaseService;
    StockManger stockManager;

    @Before
    public void setup(){
        testWebService = mock(ExternalISBNDataService.class);
        testDataBaseService =  mock(ExternalISBNDataService.class);
        stockManager = new StockManger();
        stockManager.setWebService(testWebService);
        stockManager.setDataBaseService(testDataBaseService);
    }

    @Test
    public void testCorrectLocatorCode(){
        when(testWebService.lookup(anyString())).thenReturn(new Book("0984782869", "Cracking the Coding Interview", "Gayle Laakmann McDowell"));
        when(testDataBaseService.lookup(anyString())).thenReturn(null);

        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("2869G4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        when(testDataBaseService.lookup("0984782869")).thenReturn(new Book("0984782869","abc","abc"));
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(testDataBaseService).lookup("0984782869");
        verify(testWebService, never()).lookup(anyString());
    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        when(testDataBaseService.lookup("0984782869")).thenReturn(null);
        when(testWebService.lookup("0984782869")).thenReturn(new Book("0984782869","abc","abc"));
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(testDataBaseService).lookup("0984782869");
        verify(testWebService).lookup("0984782869");
    }

}
