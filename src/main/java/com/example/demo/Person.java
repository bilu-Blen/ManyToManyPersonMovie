package com.example.demo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Movie> movies;

    public Person() {
        movies = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
