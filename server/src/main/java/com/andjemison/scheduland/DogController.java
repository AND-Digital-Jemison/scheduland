package com.andjemison.scheduland;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    private final IDogImageRetriever dog;

    public DogController(IDogImageRetriever dog) {
        this.dog = dog;
    }

    //    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dog")
    public String getDog() {
//        String uri = "https://dog.ceo/api/breeds/image/random";
//		RestTemplate restTemplate = new RestTemplate();
//        DogResponse result = restTemplate.getForObject(uri, DogResponse.class);
//        DogAPI dogAPI = new DogAPI();
        return this.dog.getDogImageUrl();
    }

}
