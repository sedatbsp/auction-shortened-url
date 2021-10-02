package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.User;
import com.sedatbsp.auctionshortenedurl.security.UserPrincipal;
import com.sedatbsp.auctionshortenedurl.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 5:41 PM
 * @project auction-shortened-url
 */
@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }

}
