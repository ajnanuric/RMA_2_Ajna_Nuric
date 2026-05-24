package com.example.tripbuddy.models;

public class City {

    String name;
    String description;
    String budget;
    int image;

    public City(String name, String description,
                String budget, int image) {

        this.name = name;
        this.description = description;
        this.budget = budget;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBudget() {
        return budget;
    }

    public int getImage() {
        return image;
    }
}