package Main;

import Service.InventoryController;
import Exceptions.*;
import Model.*;

public class QuantuamBookstoreMain {
    public static void main(String[] args) {
        System.out.println("Starting main test...");

        InventoryController controller = new InventoryController();
        //Valid moves
        try {

            PaperBook paper = new PaperBook("PB001", "Java Basics", 2018, "John Doe", 5, 1.2f);
            paper.setPrice(100);
            controller.addBook(paper);


            Ebook ebook = new Ebook("EB001", "Learn Python", 2020, "Alice Smith", "PDF", 50);
            ebook.setPrice(75);
            controller.addBook(ebook);


            DemoBook demo = new DemoBook("DB001", "Try C++", 2015, "Robert Martin");
            controller.addBook(demo);


            double paperCost = controller.buyBook("PB001", 2, "customer@mail.com", "123 Street");
            System.out.println("Bought PaperBook for $" + paperCost);


            double ebookCost = controller.buyBook("EB001", 1, "customer@mail.com", "");
            System.out.println("Bought Ebook for $" + ebookCost);


            DemoBook demoResult = controller.tryBookDemo("DB001");
            System.out.println("Tried DemoBook: " + demoResult.getTitle());

            //Invalid
            try {
                controller.tryBookDemo("PB001");
            } catch (NonDemoBookException e) {
                System.out.println("Quantum book store: Caught expected NonDemoBookException");
            }

            // INVALID
            try {
                controller.buyBook("PB001", 10, "email@mail.com", "Some Address");
            } catch (NotEnoughStockException e) {
                System.out.println("Quantum book store: Caught expected NotEnoughStockException");
            }

            // INVALID:
            try {
                controller.buyBook("EB001", 2, "email@mail.com", "");
            } catch (ExactlyOneException e) {
                System.out.println("Caught expected ExactlyOneException");
            }

            // INVALID:
            Showcase showcase = new Showcase("SC001", "Unbuyable Book", 1900, "Ancient Author");
            controller.addBook(showcase);
            try {
                controller.buyBook("SC001", 1, "email@mail.com", "123 Street");
            } catch (NonPurchasableException e) {
                System.out.println("Caught expected NonPurchasableException");
            }

            // INVALID:
            try {
                controller.searchForABook("UNKNOWN");
            } catch (NotFoundException e) {
                System.out.println("Caught expected NotFoundException for unknown ISBN");
            }

            // VALID:
            controller.removeOutdatedBooks(2016);
            System.out.println("Outdated books removed.");

        } catch (Exception e) {
            System.out.println("Unexpected error - " + e.getMessage());
        }
    }
}
