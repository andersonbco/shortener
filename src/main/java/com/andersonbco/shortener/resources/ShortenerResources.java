package com.andersonbco.shortener.resources;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.services.ShortenerService;

@RestController
public class ShortenerResources {
    
    @Autowired
    ShortenerService shortenerService;
    
    @RequestMapping(value    = "/create", 
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method   = RequestMethod.PUT)
    public ResponseEntity<Shortener> create(@RequestParam("url") String url, @RequestParam(value = "CUSTOM_ALIAS", required = false) String alias) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(shortenerService.create(url, alias, LocalDateTime.now()));
    }
    
    @RequestMapping(value    = "/{alias}",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method   = RequestMethod.GET)
    public ModelAndView retrieve(@PathVariable("alias") String alias) {
        
        return new ModelAndView("redirect:" + shortenerService.retrieve(alias).getUrl());
    }
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
    				method   = RequestMethod.GET) 
    public ResponseEntity<List<Shortener>> list() {
    	
    	return ResponseEntity.status(HttpStatus.FOUND).body(shortenerService.listTopTen());
    }
}