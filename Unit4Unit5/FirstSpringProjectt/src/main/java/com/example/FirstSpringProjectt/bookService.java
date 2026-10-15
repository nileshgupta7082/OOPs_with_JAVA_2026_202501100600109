package com.example.FirstSpringProjectt;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class bookService {

    private final ConcurrentHashMap<Long, book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public book addBook(String title, String author) {
        book newBook = new book(nextId.getAndIncrement(), title.trim(), author.trim());
        books.put(newBook.getId(), newBook);
        return newBook;
    }

    public List<book> getAllBooks() {
        return List.copyOf(books.values());
    }

    public Optional<book> getBook(long id) {
        return Optional.ofNullable(books.get(id));
    }

    public boolean borrowBook(long id) {
        book foundBook = books.get(id);
        return foundBook != null && foundBook.borrow();
    }

    public boolean returnBook(long id) {
        book foundBook = books.get(id);
        return foundBook != null && foundBook.returnBook();
    }

    public boolean deleteBook(long id) {
        return books.remove(id) != null;
    }
}
