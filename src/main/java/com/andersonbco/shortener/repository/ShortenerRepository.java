package com.andersonbco.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.shortener.domain.Shortener;

public interface ShortenerRepository extends JpaRepository<Shortener, String>{
    
    public Shortener findByAliasIgnoreCase(String alias);
}
