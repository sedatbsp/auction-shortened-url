package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.User;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 5:41 PM
 * @project auction-shortened-url
 */
public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
