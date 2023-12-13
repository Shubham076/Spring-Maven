package com.example.practise.Controllers;

import com.example.practise.Models.Author;
import com.example.practise.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
