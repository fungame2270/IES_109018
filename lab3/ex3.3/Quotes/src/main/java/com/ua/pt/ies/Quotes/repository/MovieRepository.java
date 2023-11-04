package com.ua.pt.ies.Quotes.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.pt.ies.Quotes.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    
    Optional<Movie> findByName(String Name);
}
