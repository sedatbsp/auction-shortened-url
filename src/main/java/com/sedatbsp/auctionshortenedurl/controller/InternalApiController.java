package com.sedatbsp.auctionshortenedurl.controller;

import com.sedatbsp.auctionshortenedurl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sedat Başpınar
 * @created 03.10.2021 - 7:26 PM
 * @project auction-shortened-url
 */
@RestController
@RequestMapping("api/internal")
public class InternalApiController {

    @Autowired
    private IUserService userService;

    @PutMapping("make-admin/{username}") // api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String username){
        userService.makeAdmin(username);
        return new ResponseEntity<>(HttpStatus.OK);


    }


}
