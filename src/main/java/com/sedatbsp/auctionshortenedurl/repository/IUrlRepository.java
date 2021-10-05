package com.sedatbsp.auctionshortenedurl.repository;

import com.sedatbsp.auctionshortenedurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 2:08 AM
 * @project auction-shortened-url
 */
public interface IUrlRepository extends JpaRepository<Url,Long> {

    Url findByShortenedUrl(String shortenedUrl);

}
