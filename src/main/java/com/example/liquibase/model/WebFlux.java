package com.example.liquibase.model;

public class WebFlux {
    private String name;
    private String description;
    public WebFlux(){

    }
    public WebFlux(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }
}
