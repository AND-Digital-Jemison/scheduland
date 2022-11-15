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

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dog")
    public boolean getDog() {
        return this.dog.getDogImageUrl();
    }

}
