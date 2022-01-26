package com.smolURL.smol.controller;


import com.smolURL.smol.entities.UrlMapping;
import com.smolURL.smol.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/url")
public class UrlController {

    private UrlService urlService;

    @GetMapping
    public List<UrlMapping> fetchAllUrlMappings(){
        return urlService.getAll();
    }

}
