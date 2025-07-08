package Exceptions;

public class InappropriateQuantityException extends Exception{
    public InappropriateQuantityException(){
        super("You should Order one or more to proceed.");
    }
}
