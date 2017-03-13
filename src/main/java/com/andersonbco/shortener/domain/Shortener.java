package com.andersonbco.shortener.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/** Domain class for the Shortener.
 * @author andersoncorrea
 */
@Entity
public class Shortener {
    
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(columnDefinition = "BINARY(16)")
    @JsonIgnore
    private String id;
    
    /**
     * url
     */
    private String url;
    
    /**
     * alias
     */
    private String alias;
    
    /**
     * statistics
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATISTICS_ID")
    private Statistics statistics;
    
    /**
     * constructor
     */
    public Shortener() {
        
    }
    
    /**
     * 
     * @param newUrl
     * @param newAlias
     * @param newStatistics
     */
    public Shortener(String newUrl, String newAlias, Statistics newStatistics) {
        this.url = newUrl;
        this.alias = newAlias;
        this.statistics = newStatistics;
    }
    
    /**
     * 
     * @return id
     */
    public final String getId() {
		return id;
	}

    /**
     * 
     * @param newId
     */
	public final void setId(String newId) {
		this.id = newId;
	}

	/**
	 * 
	 * @return url
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param newUrl
	 */
	public final void setUrl(String newUrl) {
		this.url = newUrl;
	}

	/**
	 * 
	 * @return alias
	 */
	public final String getAlias() {
		return alias;
	}

	/**
	 * 
	 * @param newAlias
	 */
	public final void setAlias(String newAlias) {
		this.alias = newAlias;
	}
	
	/**
	 * 
	 * @return statistics
	 */
	public Statistics getStatistics() {
	    return statistics;
	}
	
	public void setStatistics(Statistics statistics) {
	    this.statistics = statistics;
	}
}
