package com.andjemison.scheduland;

public class TestDogImageRetriever implements IDogImageRetriever {

    private final String breed;

    public TestDogImageRetriever(String breed) {
        this.breed = breed;
    }

    @Override
    public String getDogImageUrl() {
        return this.breed;
    }
}
