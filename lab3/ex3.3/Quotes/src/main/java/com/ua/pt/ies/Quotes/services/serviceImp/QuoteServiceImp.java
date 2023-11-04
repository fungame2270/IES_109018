package com.ua.pt.ies.Quotes.services.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ua.pt.ies.Quotes.entities.Movie;
import com.ua.pt.ies.Quotes.entities.Quote;
import com.ua.pt.ies.Quotes.repository.QuoteRepository;
import com.ua.pt.ies.Quotes.services.MovieService;
import com.ua.pt.ies.Quotes.services.QuoteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteServiceImp implements QuoteService {
    
    private QuoteRepository quoteRepository;
    private MovieService movieService;

    @Override
    public Quote creatQuote(Quote Quote,Long movieId) {
        Movie mv = movieService.getMovieById(movieId);
        Quote.setMovie(mv);
        Quote quote = quoteRepository.save(Quote);
        return quote;
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        Optional<Quote> quoteOptional = quoteRepository.findById(quoteId);
        return quoteOptional.get();
    }

    @Override
    public List<Quote> getAllQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes;
    }

    @Override
    public List<Quote> getAllQuotesByMovie(Long Movie) {
        List<Quote> quotes = quoteRepository.getAllQuoteByMovie(Movie);
        return quotes;
    }

    @Override
    public void deleteQuote(Long Quote) {
        quoteRepository.deleteById(Quote);
    }
    
}
