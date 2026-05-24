package com.example.tripbuddy.models;

public class Product {

    String title;
    String description;
    String price;
    int image;

    public Product(String title, String description,
                   String price, int image) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}