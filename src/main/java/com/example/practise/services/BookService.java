package com.example.practise.services;
import com.example.practise.Models.Author;
import com.example.practise.Models.Book;
import com.example.practise.Repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {
    private final BookRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book getBook(Integer id) {
        Optional<Book> book = repository.findById(id);
        return book.orElse(null);
    }
}
