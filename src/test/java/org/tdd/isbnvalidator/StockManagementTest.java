package org.tdd.isbnvalidator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jayavardhanpatil on 10/18/19
 */
public class StockManagementTest {

    ExternalISBNDataService testWebService = new ExternalISBNDataService() {

        public Book lookup(String isbn) {
            return new Book(isbn, "Cracking the Coding Interview", "Gayle Laakmann McDowell");
        }
    };

    ExternalISBNDataService testDataBaseService = new ExternalISBNDataService() {

        public Book lookup(String isbn) {
            return new Book(isbn, "Cracking the Coding Interview", "Gayle Laakmann McDowell");
        }
    };


    @Test
    public void testCorrectLocatorCode(){
        StockManger stockManager = new StockManger();
        stockManager.setWebService(testWebService);
        stockManager.setDataBaseService(testDataBaseService);
        String isbn = "0984782869";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("2869G4", locatorCode);
    }
}
