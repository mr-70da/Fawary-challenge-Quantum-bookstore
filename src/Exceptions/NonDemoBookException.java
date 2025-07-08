package Exceptions;

public class NonDemoBookException extends Exception{
    public NonDemoBookException(){
        super("This book isn't Available in a demo version.\n");
    }
}
