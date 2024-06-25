package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
        return book;
    }

    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return getBookById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return book;
        });
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
