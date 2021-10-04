package com.sedatbsp.auctionshortenedurl.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 1:36 AM
 * @project auction-shortened-url
 */
@Data
@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_url",nullable = false)
    private String originalUrl;

    @Column(name = "shortened_url",unique = true, nullable = false)
    private String shortenedUrl;

    @Column(name = "creation_date",nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

}
