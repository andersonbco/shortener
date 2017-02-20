package com.andersonbco.shortener.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATISTICS_ID")
    private Statistics statistics;
    
    public Shortener() {
        
    }
    
    public Shortener(String URL, String alias, Statistics statistics) {
        this.url = URL;
        this.alias = alias;
        this.statistics = statistics;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public Statistics getStatistics() {
	    return statistics;
	}
	
	public void setStatistics(Statistics statistics) {
	    this.statistics = statistics;
	}
}
