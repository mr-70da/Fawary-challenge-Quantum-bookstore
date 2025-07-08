package Exceptions;

public class ExactlyOneException extends Exception {
    public ExactlyOneException(String title){
        super(STR."You only can purchase exactly one Ebook of \{title}");
    }
}
