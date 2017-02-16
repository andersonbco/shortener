package com.andersonbco.shortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.repository.ShortenerRepository;
import com.andersonbco.shortener.repository.StatisticsRepository;

@Service
public class ShortenerService {
    
    @Autowired
    private ShortenerRepository shortenerRepository;
    
    @Autowired
    private StatisticsRepository statisticsRepository;
    
    public Shortener create(String URL, String alias) {
        
        Shortener shortener = new Shortener(URL, alias);
        
        return shortenerRepository.save(shortener);
    }
}
