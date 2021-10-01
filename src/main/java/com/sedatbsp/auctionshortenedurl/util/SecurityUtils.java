package com.sedatbsp.auctionshortenedurl.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 2:12 AM
 * @project auction-shortened-url
 */
public class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";

    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formattedRole);
    }

}
