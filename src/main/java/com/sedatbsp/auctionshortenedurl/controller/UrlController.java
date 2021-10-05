package com.sedatbsp.auctionshortenedurl.controller;

import com.sedatbsp.auctionshortenedurl.model.Url;
import com.sedatbsp.auctionshortenedurl.model.UrlDto;
import com.sedatbsp.auctionshortenedurl.model.UrlErrorResponseDto;
import com.sedatbsp.auctionshortenedurl.model.UrlResponseDto;
import com.sedatbsp.auctionshortenedurl.service.IUrlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Sedat Başpınar
 * @created 05.10.2021 - 3:13 AM
 * @project auction-shortened-url
 */
@RestController
@RequestMapping
public class UrlController {

    @Autowired
    private IUrlService urlService;

    @PostMapping("/api/generate") // api/generate
    public ResponseEntity<?> generateShortenedUrl(@RequestBody UrlDto urlDto){
        Url shortenedUrl = urlService.generateShortenedUrl(urlDto);

        if(shortenedUrl != null){
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setOriginalUrl(shortenedUrl.getOriginalUrl());
            urlResponseDto.setShortenedUrl(shortenedUrl.getShortenedUrl());
            urlResponseDto.setExpirationDate(shortenedUrl.getExpirationDate());

            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("İşleminiz gerçekleşirken bir hata oluştu. Lütfen tekrar deneyin.");

        return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);

    }

    @GetMapping("{shortenedUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortenedUrl, HttpServletResponse response)
            throws IOException {

        if(StringUtils.isEmpty(shortenedUrl)){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("400");
            urlErrorResponseDto.setError("Geçersiz Url");

            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }

        Url url = urlService.getEncodedUrl(shortenedUrl);
        if(url == null){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("400");
            urlErrorResponseDto.setError("Url mevcut değil veya süresi dolmuş olabilir!");

            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }

        if(url.getExpirationDate().isBefore(LocalDateTime.now())){
            urlService.deleteShortenedUrl(url);
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("200");
            urlErrorResponseDto.setError("Url'nin süresi dolmuş. Lütfen yeni bir tane oluşturmayı deneyin.");

            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
        }

        response.sendRedirect(url.getOriginalUrl());
        return null;

    }

    @GetMapping("api/getAllUrls") // api/getAllUrls
    public ResponseEntity<?> getAllUrls(){
        return new ResponseEntity<>(urlService.findAllUrls(),HttpStatus.OK);
    }


}
