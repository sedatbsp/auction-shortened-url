package com.sedatbsp.auctionshortenedurl.security.jwt;

import com.sedatbsp.auctionshortenedurl.security.UserPrincipal;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 1:54 PM
 * @project auction-shortened-url
 */
public interface IJwtProvider {
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);

    Claims extractClaims(HttpServletRequest request);
}
