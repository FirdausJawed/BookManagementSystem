package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    // TODO get -> read, post -> create, put -> update, delete -> delete
    @GetMapping("/getallbook")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}/search")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Optional<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}
