package com.andersonbco.shortener.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.domain.Statistics;
import com.andersonbco.shortener.repository.ShortenerRepository;
import com.andersonbco.shortener.repository.StatisticsRepository;
import com.andersonbco.shortener.services.exceptions.CustomAliasExistsException;
import com.andersonbco.shortener.services.exceptions.ShortenedUrlNotFoundException;
import com.andersonbco.shortener.util.Base62;

@Service
public class ShortenerService {
    
    @Autowired
    private ShortenerRepository shortenerRepository;
    
    @Autowired
    private StatisticsRepository statisticsRepository;
    
    public Shortener create(String URL, String alias, LocalDateTime requestTime) {
        
    	if(StringUtils.isEmpty(alias))
    		alias = Base62.base62Encode(URL.getBytes());
    	
    	if(find(alias).isPresent())
    		throw new CustomAliasExistsException("CUSTOM ALIAS ALREADY EXISTS");
    	
        Statistics statistics = new Statistics(TimeUnit.NANOSECONDS.toMillis(LocalDateTime.now().minusNanos(requestTime.getNano()).getNano()) + "ms", 1);
        
        statisticsRepository.save(statistics);
        
        Shortener shortener = new Shortener(URL, alias, statistics);
        
        shortenerRepository.save(shortener);
        
        return shortener;
    }
    
    public Shortener retrieve(String alias) {

    	Optional<Shortener> shortener = find(alias);
    	
    	if(shortener.isPresent())
    	{
    		updateAccessCount(alias);
    		return shortener.get();
    	}
    	else
    		throw new ShortenedUrlNotFoundException("SHORTENED URL NOT FOUND");
    }
    
    public List<Shortener> listTopTen() {
    	return shortenerRepository.findAll().stream().sorted((c1, c2) -> c2.getStatistics().
    			getAccessCount().compareTo(c1.getStatistics().getAccessCount())).limit(10).collect(Collectors.toList());
    }
    
    private Optional<Shortener> find(String alias) {
    	return Optional.ofNullable(shortenerRepository.findByAliasIgnoreCase(alias));
    }
    
    private void updateAccessCount(String alias) {
    	Statistics statistics = find(alias).get().getStatistics();
    	statistics.setAccessCount(statistics.getAccessCount().intValue() + 1);
    	
    	statisticsRepository.save(statistics);
    }
}