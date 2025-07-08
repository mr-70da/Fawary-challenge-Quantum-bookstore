package Exceptions;

import Model.Book;

public class NotFoundException extends Exception{
    public NotFoundException(String ISBN){
        super(STR."The book with ISBN \{ISBN} does not exist.\n");

    }
}
