package com.andersonbco.shortener.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Shortener {
    
    private String alias;
    
    private String url;
    
    private List<Statistics> statistics;
}
