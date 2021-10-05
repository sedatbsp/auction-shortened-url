package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.Url;
import com.sedatbsp.auctionshortenedurl.model.UrlDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 2:32 AM
 * @project auction-shortened-url
 */
public interface IUrlService {

    Url generateShortenedUrl(UrlDto urlDto);

    Url persistShortenedUrl(Url url);

    Url getEncodedUrl(String url);

    void deleteShortenedUrl(Url url);

    void deleteShortenedUrl(String url);

    List<Url> findAllUrls();
}
