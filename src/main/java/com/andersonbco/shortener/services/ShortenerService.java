package com.andersonbco.shortener.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.domain.Statistics;
import com.andersonbco.shortener.repository.ShortenerRepository;
import com.andersonbco.shortener.repository.StatisticsRepository;

@Service
public class ShortenerService {
    
    @Autowired
    private ShortenerRepository shortenerRepository;
    
    @Autowired
    private StatisticsRepository statisticsRepository;
    
    public Shortener create(String URL, String alias) {
        
        Statistics statistics = new Statistics(LocalDateTime.now());
        
        statisticsRepository.save(statistics);
        
        Shortener shortener = new Shortener(URL, alias, statistics);
        
        shortenerRepository.save(shortener);
        
        return shortener;
    }
    
    public Shortener findByAliasIgnoreCase(String alias) {
        
        return shortenerRepository.findByAliasIgnoreCase(alias);
    }
}
