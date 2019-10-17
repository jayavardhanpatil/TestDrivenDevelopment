package org.tdd.isbnvalidator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FirstTestExample {

    @Test
    public void exampleTest(){

        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN(0201633612);
        assertTrue(result);
    }
}
