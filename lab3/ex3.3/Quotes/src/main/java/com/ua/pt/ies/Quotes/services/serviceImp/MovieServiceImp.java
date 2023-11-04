package com.ua.pt.ies.Quotes.services.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ua.pt.ies.Quotes.entities.Movie;
import com.ua.pt.ies.Quotes.repository.MovieRepository;
import com.ua.pt.ies.Quotes.services.MovieService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImp implements MovieService{

    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.get();
    }

    @Override
    public List<Movie> getAllMovie() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @Override
    public Movie getMovieByName(String name) {
        Optional<Movie> optionalMovie = movieRepository.findByName(name);
        return optionalMovie.get();
    }

    @Override
    public void deleteMovie(Long Movie) {
        movieRepository.deleteById(Movie);
    }
    
}
