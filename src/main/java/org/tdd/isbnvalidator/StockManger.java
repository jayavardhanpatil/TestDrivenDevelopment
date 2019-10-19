package org.tdd.isbnvalidator;

/**
 * Created by jayavardhanpatil on 10/18/19
 */
public class StockManger {

    private ExternalISBNDataService webService;

    public void setDataBaseService(ExternalISBNDataService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    private ExternalISBNDataService dataBaseService;
    public void setWebService(ExternalISBNDataService webService){
        this.webService = webService;
    }


    public String getLocatorCode(String isbn){
        Book book = dataBaseService.lookup(isbn);
        if (book == null) book = webService.lookup(isbn);

        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length() - 4)).append(book.getAuthor().substring(0,1))
                .append(book.getTitle().split(" ").length);
        return locator.toString();
    }
}
