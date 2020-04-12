/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EdgeService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sinan
 */

@RestController
public class MovieRestController {
    
    @Autowired
    private IMovieClient movieClient;
    
    /*public MovieRestController(IMovieClient movieClient){
        this.movieClient = movieClient;
    }*/
    
    @GetMapping("/movies")
    @HystrixCommand(fallbackMethod = "fallbackMovies")
    public Collection<Movie> getMovies(){
        return movieClient.readMovies().getContent().stream().collect(Collectors.toList());
    }
    
    public Collection<Movie> fallbackMovies(){
        List<Movie> movies = new ArrayList<>();
        Movie m = new Movie();
        m.setName("Fallback Movie");
        m.setRating(8);
        movies.add(m);
        return movies;
        
    }
}
