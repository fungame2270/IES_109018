package com.ua.pt.ies.Quotes.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ua.pt.ies.Quotes.entities.Movie;
import com.ua.pt.ies.Quotes.services.MovieService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/Movie")
public class MovieController {
    
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie Movie){
        Movie savedMovie = movieService.createMovie(Movie);
        return new ResponseEntity<>(savedMovie,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId){
        Movie mv = movieService.getMovieById(movieId);
        return new ResponseEntity<>(mv,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> listmovie = movieService.getAllMovie();
        return new ResponseEntity<>(listmovie,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovieById(@RequestParam("id")Long movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie deleted",HttpStatus.OK);
    }
}
