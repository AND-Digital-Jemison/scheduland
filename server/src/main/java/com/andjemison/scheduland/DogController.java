package com.andjemison.scheduland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DogController {

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dog")
    public String getDog(IDog dog) {
//        String uri = "https://dog.ceo/api/breeds/image/random";
//		RestTemplate restTemplate = new RestTemplate();
//        DogResponse result = restTemplate.getForObject(uri, DogResponse.class);
//        DogAPI dogAPI = new DogAPI();
        return dog.getDogImageUrl();
    }

}
