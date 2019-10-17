package org.tdd.isbnvalidator;

public class ValidateISBN {


    public boolean checkISBN(String isbn) {

        if(isbn.length() < 10) throw new NumberFormatException("ISBN Number should be 10 Digit long");

        int total = 0;
        for (int i = 0; i < 10; i++) {

            if(!Character.isDigit(isbn.charAt(i))){
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                }else {
                    throw new NumberFormatException("ISBN Number should be Integer or can have X");
                }
            }
            else {
                total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
            }
        }
        return total % 11 == 0;
    }
}
