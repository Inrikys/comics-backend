package com.estudo.designpattern.marvel.comic;

import com.estudo.designpattern.client.marvel.MarvelClient;
import com.estudo.designpattern.client.marvel.dto.MarvelComicResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MarvelComicService {

    @Autowired
    private MarvelClient marvelClient;

    @Value("${marvel.api.key}")
    private String apiKey;

    @Value("${marvel.api.ts}")
    private String apiTs;

    @Value("${marvel.api.hash}")
    private String apiHash;

    public MarvelComicResponse findById(Long comicId) {
        try {
            return marvelClient.getComicById(comicId, apiTs, apiKey, apiHash);
        } catch (FeignException e) {
            throw e;
        }
    }
}
