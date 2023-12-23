package com.example.practise.Controllers;
import com.example.practise.Models.Book;
import com.example.practise.services.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookService service;

    public BookController(BookService service){
        this.service = service;
    }
    @PostMapping(path = "/book")
    public Book createBook(@Valid @RequestBody Book book) {
        return service.createBook(book);
    }

    @GetMapping(path = "/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        Book b = service.getBook(id);
        return b;
    }
}
