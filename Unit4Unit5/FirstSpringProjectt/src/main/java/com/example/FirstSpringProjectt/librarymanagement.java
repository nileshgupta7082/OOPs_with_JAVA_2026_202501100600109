package com.example.FirstSpringProjectt;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/books")
public class librarymanagement {

    private final ConcurrentHashMap<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequest request) {
        if (request == null || request.title() == null || request.title().isBlank()
                || request.author() == null || request.author().isBlank()) {
            return ResponseEntity.badRequest().body("Title and author are required.");
        }

        Book book = new Book(nextId.getAndIncrement(), request.title().trim(), request.author().trim());
        books.put(book.getId(), book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return List.copyOf(books.values());
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<?> borrowBook(@PathVariable long id) {
        Book book = books.get(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        if (!book.borrow()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book is already borrowed.");
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable long id) {
        Book book = books.get(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        if (!book.returnBook()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book is not currently borrowed.");
        }
        return ResponseEntity.ok(book);
    }

    public record BookRequest(String title, String author) {
    }

    public static class Book {
        private final long id;
        private final String title;
        private final String author;
        private boolean borrowed;

        public Book(long id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public synchronized boolean isBorrowed() {
            return borrowed;
        }

        public synchronized boolean borrow() {
            if (borrowed) {
                return false;
            }
            borrowed = true;
            return true;
        }

        public synchronized boolean returnBook() {
            if (!borrowed) {
                return false;
            }
            borrowed = false;
            return true;
        }
    }
}
