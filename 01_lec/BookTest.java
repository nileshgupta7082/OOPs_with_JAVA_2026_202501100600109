public class BookTest {

    public static void main(String[] args) {

        Book book1 = new Book(
            "Java Programming",
            "James Gosling",
            599.99,
            "ISBN001"
        );

        Book book2 = new Book(
            "Python Basics",
            "Guido van Rossum",
            499.99,
            "ISBN002"
        );

        // Display book 1
        System.out.println("Book 1");
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Price: " + book1.getPrice());
        System.out.println("ISBN: " + book1.getIsbn());
        System.out.println("Library: " + book1.libraryName);

        System.out.println();

        // Display book 2
        System.out.println("Book 2");
        System.out.println("Title: " + book2.getTitle());
        System.out.println("Author: " + book2.getAuthor());
        System.out.println("Price: " + book2.getPrice());
        System.out.println("ISBN: " + book2.getIsbn());

        System.out.println();

        // Total books
        System.out.println("Total books: " + Book.getBookCount());
    }
}