package com.example.practise.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "author")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "book name is required")
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="author", nullable=false)
    @NotNull(message = "author is required")
    private Author author;
}
