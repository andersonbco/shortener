package com.andersonbco.shortener.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Statistics {
    
    @Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "STATISTICS_ID", columnDefinition = "BINARY(16)")
	@JsonIgnore
    private String id;
    
    private LocalDateTime timeTaken;
    
    public Statistics() {
        
    }
    
    public Statistics( LocalDateTime timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public LocalDateTime getTimeTaken() {
	    return timeTaken;
	}
	
	public void setTimeTaken(LocalDateTime timeTaken) {
	    this.timeTaken = timeTaken;
	}
}
