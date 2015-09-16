package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.persistence.BookRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BookController {
    @Inject
    BookRepository repository;
    private String title;
    private Book.Genre genre;
    private String author;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public String createBook(){
        Book book = new Book(title, author, genre);
        repository.createBook(book);
        return "books";
    }

    public void remove(int bookId) {
        repository.remove(bookId);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(Book.Genre genre) {
        this.genre = genre;
    }

    public Book.Genre getGenre() {
        return genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
