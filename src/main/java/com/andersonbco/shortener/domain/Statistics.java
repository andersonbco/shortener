package com.andersonbco.shortener.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Statistics {
    
    private String id;
    
    private LocalDateTime timeTaken;
}
