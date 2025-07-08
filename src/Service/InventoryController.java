package Service;

import Exceptions.*;
import Model.Book;
import Model.DemoBook;
import Model.Ebook;
import Model.PaperBook;

import java.util.HashMap;
import java.util.Map;

public class InventoryController {
    ShippingController shippingController = new ShippingController();
    EmailController emailController = new EmailController();
    private Map<String,Book> inventory = new HashMap<>();
    public void addBook(Book book){
        inventory.put(book.getISBN(),book);
    }
    public void removeBook(String ISBN) throws Exception{
        Book currentBook  = searchForABook(ISBN);
        inventory.remove(currentBook);

    }
    public void removeOutdatedBooks(int year){
        for (Map.Entry<String , Book> book : inventory.entrySet()){
            if(book.getValue().getPublishedYear() < year){
                inventory.remove(book);
            }
        }
    }
    public Book searchForABook(String ISBN) throws Exception{
        for (Map.Entry<String , Book> book : inventory.entrySet()){
            if(ISBN.equals(book.getKey())){
                return book.getValue();
            }
        }
        throw new NotFoundException(ISBN);
    }
    public double buyBook(String ISBN , int quantity,String email, String address) throws Exception {
        Book currentBook  = searchForABook(ISBN);
        double totalCost = 0;
        if (currentBook instanceof PaperBook){
            if(((PaperBook) currentBook).getStock() <quantity){
                throw new NotEnoughStockException();
            }
            if(quantity <1){
                throw new InappropriateQuantityException();
            }
            totalCost = (quantity*((PaperBook) currentBook).getPrice());
            ((PaperBook) currentBook).removeFromStock(quantity);
            shippingController.ship((PaperBook) currentBook);
        }else if(currentBook instanceof Ebook){
            if(quantity!=1){
                throw new ExactlyOneException(currentBook.getTitle());
            }
            totalCost = ( (Ebook)currentBook).getPrice();
            emailController.sent((Ebook) currentBook);
        }else{
            throw new NonPurchasableException(currentBook);
        }
        return totalCost;
    }
    public DemoBook tryBookDemo(String ISBN ) throws Exception {
        Book currentBook  = searchForABook(ISBN);
        double totalCost = 0;
        if (!(currentBook instanceof DemoBook)){
            throw new NonDemoBookException();
        }
        return (DemoBook) currentBook;
    }


}
