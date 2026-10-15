package com.example.FirstSpringProjectt;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class bookController {

    private final bookService bookService;

    public bookController(bookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequest request) {
        if (request == null || request.title() == null || request.title().isBlank()
                || request.author() == null || request.author().isBlank()) {
            return ResponseEntity.badRequest().body("Title and author are required.");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.addBook(request.title(), request.author()));
    }

    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<book> getBook(@PathVariable long id) {
        return bookService.getBook(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<?> borrowBook(@PathVariable long id) {
        return bookService.getBook(id)
                .map(foundBook -> {
                    if (!bookService.borrowBook(id)) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body("Book is already borrowed.");
                    }
                    return ResponseEntity.ok(foundBook);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable long id) {
        return bookService.getBook(id)
                .map(foundBook -> {
                    if (!bookService.returnBook(id)) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body("Book is not currently borrowed.");
                    }
                    return ResponseEntity.ok(foundBook);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        if (!bookService.deleteBook(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    public record BookRequest(String title, String author) {
    }
}
