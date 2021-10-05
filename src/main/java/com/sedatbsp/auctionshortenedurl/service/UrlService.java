package com.sedatbsp.auctionshortenedurl.service;

import com.google.common.hash.Hashing;
import com.sedatbsp.auctionshortenedurl.model.Url;
import com.sedatbsp.auctionshortenedurl.model.UrlDto;
import com.sedatbsp.auctionshortenedurl.repository.IUrlRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 2:32 AM
 * @project auction-shortened-url
 */
@Service
public class UrlService implements IUrlService{

    @Autowired
    private IUrlRepository urlRepository;

    public Url generateShortenedUrl(UrlDto urlDto){
        if(StringUtils.isNotEmpty(urlDto.getUrl())){
            String encodedUrl = encodeUrl(urlDto.getUrl());

            Url urlToPersist = new Url();
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortenedUrl(encodedUrl);
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToPersist.getCreationDate()));

            Url shortenedUrl = persistShortenedUrl(urlToPersist);

            if(shortenedUrl != null){
                return shortenedUrl;
            }
            return null;

        }
        return null;
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if(StringUtils.isBlank(expirationDate)){
            return creationDate.plusMonths(6);
        }
        LocalDateTime createdExpirationDate = LocalDateTime.parse(expirationDate);
        return createdExpirationDate;
    }


    @Override
    public Url persistShortenedUrl(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public Optional<Url> getEncodedUrl(String url) {
        return urlRepository.findByShortenedUrl(url);
    }

    @Override
    public void deleteShortenedUrl(Url url) {
        urlRepository.delete(url);

    }
}
