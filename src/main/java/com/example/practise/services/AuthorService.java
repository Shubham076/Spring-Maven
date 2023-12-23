package com.example.practise.services;
import com.example.practise.Models.Author;
import com.example.practise.Repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuthorService {
    private final AuthorRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    public Author getAuthor(Integer id) {
        Optional<Author> author = repository.findById(id);
        return author.orElse(null);
    }
}
