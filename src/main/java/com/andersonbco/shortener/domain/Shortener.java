package com.andersonbco.shortener.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shortener {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition = "BINARY(16)")
    @JsonIgnore
    private String id;
    
    private String url;
        
    private String alias;
    
    @OneToMany(mappedBy="shortener", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Statistics> statistics;
}
