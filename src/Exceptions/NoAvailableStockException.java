package Exceptions;

import Model.Book;

public class NoAvailableStockException extends Exception {
    public NoAvailableStockException(Book book){
        super(STR."Ops, \{book} is out of our stock right now.\n");

    }
}
