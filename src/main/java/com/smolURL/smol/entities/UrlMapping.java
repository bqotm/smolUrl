package com.smolURL.smol.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class UrlMapping {
    @Id
    private String id;
    private String xsUrl;
    private String xlUrl;
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;

    public UrlMapping(String xsUrl, String xlUrl, LocalDateTime createdDate, LocalDateTime expirationDate) {
        this.xsUrl = xsUrl;
        this.xlUrl = xlUrl;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
    }
}
