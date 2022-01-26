package com.smolURL.smol.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class UrlRequest {

    private String originalUrl;
    private String customXsUrl;

}
