package com.ua.pt.ies.Quotes.services;

import java.util.List;

import com.ua.pt.ies.Quotes.entities.Movie;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie getMovieById(Long movieId);

    List<Movie> getAllMovie();

    Movie getMovieByName(String name);

    void deleteMovie(Long Movie);

}
