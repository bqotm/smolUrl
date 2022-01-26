package com.smolURL.smol.service;


import com.smolURL.smol.entities.UrlMapping;
import com.smolURL.smol.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UrlService {

    private UrlRepository urlRepository;

    public List<UrlMapping> getAll(){
        return urlRepository.findAll();
    }

}
