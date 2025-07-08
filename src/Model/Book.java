package Model;

public abstract class Book {
    String ISBN;
    String title;
    int publishedYear;
    String auther;

    public Book(String ISBN, String title, int publishedYear ,String auther) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishedYear = publishedYear;
        this.auther = auther;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }


}
