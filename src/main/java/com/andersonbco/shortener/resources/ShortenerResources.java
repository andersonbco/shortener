package com.andersonbco.shortener.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.shortener.domain.Shortener;

@RestController
@RequestMapping(value = "/shortener")
public class ShortenerResources {
    
    @RequestMapping(value = "/create", params = {"url", "CUSTOM_ALIAS"}, method = RequestMethod.PUT)
    public ResponseEntity<Shortener> create(@RequestParam("url") String url, @RequestParam("CUSTOM_ALIAS") String alias) {
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
