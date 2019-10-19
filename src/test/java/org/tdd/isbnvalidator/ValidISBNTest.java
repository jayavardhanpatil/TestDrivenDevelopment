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
    public void check13DigitINSB(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780984782857");
        assertTrue("13 digit ISBN ",result);
    }

    @Test
    public void check10DigitInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0201633613");
        assertFalse(result);
    }

    @Test
    public void check13DigitInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780984782856");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNValidation(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("020163361");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNCheck(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("HelloWorld");
    }

    @Test
    public void tenDigitISBNEndingWithXisValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue("ISBN Ending with X ",result);
    }

}
