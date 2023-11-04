package com.ua.pt.ies.Quotes.repository;

import com.ua.pt.ies.Quotes.entities.Quote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote,Long> {
    
    @Query("SELECT q FROM Quote q WHERE q.movie = ?1")
    List<Quote> getAllQuoteByMovie(Long Movie);
}
