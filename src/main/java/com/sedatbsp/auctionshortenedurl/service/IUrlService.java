package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.Url;

import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 2:32 AM
 * @project auction-shortened-url
 */
public interface IUrlService {

    Url persistShortenedUrl(Url url);

    Optional<Url> getEncodedUrl(String url);

    void deleteShortenedUrl(Url url);

}
