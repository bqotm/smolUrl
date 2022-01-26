package com.smolURL.smol.repository;

import com.smolURL.smol.entities.UrlMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlMapping, String> {


}
