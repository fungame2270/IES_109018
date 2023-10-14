package com.ua.deti.RestApiQuotes;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteApiController {
    InformationMap infoMap = new InformationMap();
    
    @GetMapping("/quote")
    public Quote quote(){
        return infoMap.getRandomQuote();
    }
    @GetMapping("/shows")
    public List<Shows> Shows(){
        return infoMap.getShows();
    }
    @GetMapping("/quotes")
    public List<Quote> quotes(@RequestParam(value = "id") int id){
        return infoMap.getQuotesShow(id);
    }
}
