package com.andjemison.scheduland;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    private final IDogImageRetriever dogImageRetriever;

    public DogController(IDogImageRetriever dog) {
        this.dogImageRetriever = dog;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dog")
    public boolean getDog() {
        //return this.dog.getDogImageUrl();
        var dog = this.dogImageRetriever.getDogImageUrl();
        var urlSplits = dog.split("/");
        var breed = urlSplits[urlSplits.length-2];
        return "abcdefghijklm".contains(breed.substring(0,1));
    }

}
