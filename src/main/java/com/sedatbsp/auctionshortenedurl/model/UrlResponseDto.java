package com.sedatbsp.auctionshortenedurl.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 1:56 AM
 * @project auction-shortened-url
 */
@Data
public class UrlResponseDto {

    private String originalUrl;
    private String shortenedUrl;
    private LocalDateTime expirationDate;


}
