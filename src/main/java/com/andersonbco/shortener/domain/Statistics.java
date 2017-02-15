package com.andersonbco.shortener.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Statistics {
    
    @Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition = "BINARY(16)")
	@JsonIgnore
    private String id;
    
    private LocalDateTime timeTaken;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHORTENER_ID")
    @JsonIgnore
    private Shortener shortener;
}
