package Model;

public class PaperBook extends Book implements Shippable ,Purchasable{
    private int stock;
    private double price;
    private float weight;

    public PaperBook(String ISBN, String title, int publishedYear, String auther, int stock, float weight) {
        super(ISBN, title, publishedYear, auther);
        this.stock = stock;
        this.weight = weight;
    }

    public int getStock() {
        return stock;
    }

    public void addToStock(int quantity){
        this.stock+=quantity;
    }
    public void removeFromStock(int quantity){
        this.stock-=quantity;
    }
    @Override
    public float getWeight() {
        return weight;
    }
    @Override
    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
