package Exceptions;

import Model.Book;

public class NotEnoughStockException extends Exception {
    public NotEnoughStockException(){
        super(STR."The available stock is not enough for your order.");
    }
}
