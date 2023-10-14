package com.ua.deti.RestApiQuotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InformationMap {
    Map<Integer,String> movies = new HashMap<>();
    List<QuoteMovie> quotes = new ArrayList<>();

    InformationMap(){
        movies.put(1, "Titanic(1997)");
        quotes.add(new QuoteMovie(1,"Don't you do that, don't say your good-byes. Not yet, do you understand me?"));
        quotes.add(new QuoteMovie(1,"I'm so cold."));
        quotes.add(new QuoteMovie(1,"Never let go."));
        movies.put(2,"Ford v Ferrari(2019)");
        quotes.add(new QuoteMovie(2,"We're lighter, we're faster, and if that don't work, we're nastier. "));
        quotes.add(new QuoteMovie(2,"Nice stopwatch"));
        quotes.add(new QuoteMovie(2,"You're gonna build a car to beat Ferrari with... a Ford."));
        movies.put(3,"The Italian Job(2003)");
        quotes.add(new QuoteMovie(3,"This dude got dogs. I don't do dogs... I had a real bad experience, man."));
        quotes.add(new QuoteMovie(3,"You blew the best thing you had going for you. You blew the element of surprise. "));
        quotes.add(new QuoteMovie(3,"Same old Steve huh? Always thinking defensively. That's why you're always number two. "));
    }

    Quote getRandomQuote(){
        Random r = new Random();
        int rundom = r.nextInt(quotes.size()+1);
        QuoteMovie q = quotes.get(rundom);
        return new Quote(q.quote,movies.get(q.movie));
    }

    List<Shows> getShows(){
        List<Shows> shows = new ArrayList<>();
        for (int i = 1; i <= movies.size(); i++) {
            String m = movies.get(i);
            shows.add(new Shows(i, m));
        }
        return shows;
    }

    List<Quote> getQuotesShow(int id){
        List<Quote> returnList = new ArrayList<>();
        for (QuoteMovie quoteMovie : quotes) {
            if (quoteMovie.movie == id){
                returnList.add(new Quote(movies.get(quoteMovie.movie),quoteMovie.quote));
            }
        }
        return returnList;
    }
}
