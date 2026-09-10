class Book{
    private String title;
    private String author;
    private double price;
    private String isbn;
    static int bookCount =0;
    final static String libraryName = "Sunrise Public Library";

    Book(String title, String author, double price, String isbn){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        bookCount++;
    }

    void setTitle(String title){
        this.title = title;
    }
    void setAuthor(String author){
        this.author = author;
    }
    void setPrice(double price){
        this.price = price;
    }
    void setISBN(String isbn){
        this.isbn = isbn;
    }
    String getTitle(){
        return title;
    }
    String getAuthor(){
        return author;
    }
    double getPrice(){
        return price;
    }
    String getISBN(){
        return isbn;
    }


}
public class UseCase1 {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "J. Author", 350.0, "ISBN001");
        Book b2 = new Book("OOP Concepts", "K. Writer", 420.0, "ISBN002");
 
        System.out.println(b1.getTitle() + " by " + b1.getAuthor());
        System.out.println("Price: " + b2.getPrice());
    
        System.out.println("Library: " + Book.libraryName);
        System.out.println("Total books added: " + Book.bookCount);
    }
}