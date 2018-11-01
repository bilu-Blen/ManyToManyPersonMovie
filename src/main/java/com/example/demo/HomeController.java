package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){

        //creating person
        Person person = new Person();
        person.setName("Blen");

        //declaring a list of movies
        Set<Movie> movies = new HashSet<Movie>();

        //create a favorite movie
        Movie movie = new Movie();
        movie.setName("FireProof");
        movie.setYear(2018);
        movies.add(movie);

        movie = new Movie();
        movie.setName("NoteBook");
        movie.setYear(2004);
        movies.add(movie);

        person.setMovies(movies);

        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());

        return "index";
    }
}
