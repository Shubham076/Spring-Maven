package com.example.practise.services;
import com.example.practise.Models.Author;
import com.example.practise.Repositories.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {
    private final AuthorRepository repository;
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }
    public Author createAuthor(Author author) {
        return repository.save(author);
    }
}
