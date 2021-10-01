package com.sedatbsp.auctionshortenedurl.service;

import com.sedatbsp.auctionshortenedurl.model.Role;
import com.sedatbsp.auctionshortenedurl.model.User;
import com.sedatbsp.auctionshortenedurl.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Sedat Başpınar
 * @created 02.10.2021 - 2:02 AM
 * @project auction-shortened-url
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username,Role.ADMIN);
    }


}
