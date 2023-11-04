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

import com.ua.pt.ies.Quotes.entities.Quote;
import com.ua.pt.ies.Quotes.services.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/Quote")
public class QuoteController {
    
    private QuoteService quoteService;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote,@RequestParam Long movieId){
        Quote savedQuote = quoteService.creatQuote(quote,movieId);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long quoteId){
        Quote quote = quoteService.getQuoteById(quoteId);
        return new ResponseEntity<Quote>(quote, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes(@RequestParam(required = false)Long movieId){
        List<Quote> quotes;
        if(movieId == null){
            quotes = quoteService.getAllQuotes();
        }else{
            quotes = quoteService.getAllQuotesByMovie(movieId);
        }
        return new ResponseEntity<List<Quote>>(quotes, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable("id") Long quoteId){
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>("Quote deleted",HttpStatus.OK);
    }
}
