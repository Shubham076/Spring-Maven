package com.example.practise.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.practise.Models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
