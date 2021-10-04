package com.sedatbsp.auctionshortenedurl.model;

import lombok.*;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 1:52 AM
 * @project auction-shortened-url
 */
@Data
public class UrlDto {

    private String url;
    private String expirationDate; // optional



}
