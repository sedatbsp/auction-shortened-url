package com.sedatbsp.auctionshortenedurl.model;

import lombok.Data;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 1:58 AM
 * @project auction-shortened-url
 */
@Data
public class UrlErrorResponseDto {

    private String status;
    private String error;

}
