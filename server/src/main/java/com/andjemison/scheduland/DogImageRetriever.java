package com.andjemison.scheduland;

import org.springframework.web.client.RestTemplate;

public class DogImageRetriever implements IDog {
    @Override
    public String getDogImageUrl() {
        String uri = "https://dog.ceo/api/breeds/image/random";
        RestTemplate restTemplate = new RestTemplate();
        DogResponse result = restTemplate.getForObject(uri, DogResponse.class);
        return result.getMessage();
    }
}
