package com.example.practise.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;


//@Entity as a way of saying, "This Java class represents something that I want to store in the database.
//The @Table annotation is used in conjunction with @Entity to specify the primary table for the annotated entity.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "books")
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "author name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "age is required")
    @Column(nullable = false)
    private String age;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;
}
