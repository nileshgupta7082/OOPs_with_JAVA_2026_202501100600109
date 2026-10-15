package com.example.FirstSpringProjectt;

public class book {

    private long id;
    private String title;
    private String author;
    private boolean borrowed;

    public book() {
    }

    public book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
