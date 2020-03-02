package com.desafios.desafio5.model;

public class Animales {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animales(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
