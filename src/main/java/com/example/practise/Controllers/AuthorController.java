package com.example.practise.Controllers;

import com.example.practise.Models.Author;
import com.example.practise.services.AuthorService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }
    @PostMapping(path = "/author")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return service.createAuthor(author);
    }

    @GetMapping(path = "/author/{id}")
    public Author getAuthor(@PathVariable("id") Integer id) {
        Author a = service.getAuthor(id);
        System.out.println(a.getBooks().get(0).getName());
        return a;
    }
}
