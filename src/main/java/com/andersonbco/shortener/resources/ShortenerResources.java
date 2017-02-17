package com.andersonbco.shortener.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.shortener.domain.Shortener;
import com.andersonbco.shortener.services.ShortenerService;

@RestController
@RequestMapping(value = "/shortener")
public class ShortenerResources {
    
    @Autowired
    ShortenerService shortenerService;
    
    @RequestMapping(value    = "/create", 
                    params   = {"url", "CUSTOM_ALIAS"},
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method   = RequestMethod.PUT)
    public ResponseEntity<Shortener> create(@RequestParam("url") String url, @RequestParam("CUSTOM_ALIAS") String alias) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(shortenerService.create(url, alias));
    }
    
    @RequestMapping(value    = "/{alias}",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method   = RequestMethod.GET)
    public ResponseEntity<Shortener> search(@PathVariable("alias") String alias) {
        
        return ResponseEntity.status(HttpStatus.FOUND).body(shortenerService.findByAliasIgnoreCase(alias));
    }
}
