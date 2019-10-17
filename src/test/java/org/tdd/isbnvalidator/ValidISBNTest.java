package org.tdd.isbnvalidator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidISBNTest {

    @Test
    public void checkValidISBN(){

        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0201633612");
        assertTrue("First Value ",result);
        result = validator.checkISBN("1484240774");
        assertTrue("Second value ", result);

    }

    @Test
    public void checkInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0201633613");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNValidation(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("020163361");

    }
}
