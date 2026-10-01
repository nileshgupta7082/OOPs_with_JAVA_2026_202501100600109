import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    int pages;

    Book(int bookId, String title, int pages) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
    }

    void display() {
        System.out.println(bookId + "  " + title + "  " + pages);
    }
}

// Comparator for sorting books
class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {

        // First: sort by pages iṇn ascending order
        if (b1.pages != b2.pages) {
            return Integer.compare(b1.pages, b2.pages);
        }

        // If pages are same: sort by title alphabetically
        return b1.title.compareTo(b2.title);
    }
}

public class BookSortingSystem {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(101, "Java Basics", 150));
        books.add(new Book(104, "Data Structures", 150));
        books.add(new Book(103, "Computer Networks", 250));
        books.add(new Book(102, "Operating Systems", 400));

        // Sort using Comparator
        Collections.sort(books, new BookComparator());

        System.out.println("Book Details:");
        System.out.println("ID  Title  Pages");

        for (Book b : books) {
            b.display();
        }
    }
}