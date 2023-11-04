package com.ua.pt.ies.Quotes.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;
    @Column(nullable = false)
    private String quote;
    @ManyToOne
    @JoinColumn(name = "movieId",nullable = false,referencedColumnName = "movieId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movie movie;

    @JsonCreator
    public Quote(@JsonProperty String quote){
        this.quote = quote;
    }
}
