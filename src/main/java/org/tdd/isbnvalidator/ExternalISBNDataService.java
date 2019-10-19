package org.tdd.isbnvalidator;

/**
 * Created by jayavardhanpatil on 10/18/19
 */
public interface ExternalISBNDataService {

    public Book lookup(String isbn);

}
