package Exceptions;

import Model.Book;

public class NonPurchasableException extends Exception {
    public NonPurchasableException(Book book){
        super(STR."\"\{book.getTitle()}\" is not available for buying.\n");
    }

}
