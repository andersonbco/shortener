package com.andersonbco.shortener.domain;

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
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "STATISTICS_ID", columnDefinition = "BINARY(16)")
	@JsonIgnore
    private String id;
    
    private String timeTaken;
    
    private Integer accessCount;
    
    public Statistics() {
        
    }
    
    public Statistics(String timeTaken, Integer accessCount) {
        this.timeTaken = timeTaken;
        this.accessCount = accessCount;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTimeTaken() {
	    return timeTaken;
	}
	
	public void setTimeTaken(String timeTaken) {
	    this.timeTaken = timeTaken;
	}

	public Integer getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(Integer accessCount) {
		this.accessCount = accessCount;
	}
}
