package com.andjemison.scheduland;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogImageRetrieverServiceImageRetriever implements IDogImageRetriever {
    @Override
    public String getDogImageUrl() {
        String uri = "https://dog.ceo/api/breeds/image/random";
        RestTemplate restTemplate = new RestTemplate();
        DogResponse result = restTemplate.getForObject(uri, DogResponse.class);
        return result.getMessage();
    }
}

