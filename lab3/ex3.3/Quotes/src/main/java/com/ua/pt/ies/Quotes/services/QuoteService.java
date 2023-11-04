package com.ua.pt.ies.Quotes.services;

import java.util.List;

import com.ua.pt.ies.Quotes.entities.Quote;

public interface QuoteService {
    Quote creatQuote(Quote Quote,Long movieId);

    Quote getQuoteById(Long quoteId);

    List<Quote> getAllQuotes();

    List<Quote> getAllQuotesByMovie(Long Movie);

    void deleteQuote(Long Quote); 
}
