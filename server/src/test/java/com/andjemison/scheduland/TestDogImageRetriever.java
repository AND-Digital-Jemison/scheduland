package com.andjemison.scheduland;

public class TestDogImageRetriever implements IDogImageRetriever {

    private final String url;

    public TestDogImageRetriever(String url) {
        this.url = url;
    }

    @Override
    public String getDogImageUrl() {
        return this.url;
    }
}
