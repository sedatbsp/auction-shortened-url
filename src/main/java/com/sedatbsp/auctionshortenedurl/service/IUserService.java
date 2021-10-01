package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.User;

import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 2:02 AM
 * @project auction-shortened-url
 */
public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
