package Model;

public class Ebook extends Book implements Emailable,Purchasable{
   private String fileType;
   private double price;

   public Ebook(String ISBN, String title, int publishedYear, String auther, String fileType , double price) {
      super(ISBN, title, publishedYear, auther);
      this.fileType = fileType;
      this.price = price;
   }

   @Override
   public Ebook getFile() {
      return this;

   }

   @Override
   public double getPrice() {
      return this.price;
   }

   @Override
   public void setPrice(double price) {
      this.price = price;

   }

   public String getFileType() {
      return fileType;
   }

   public void setFileType(String fileType) {
      this.fileType = fileType;
   }
}
