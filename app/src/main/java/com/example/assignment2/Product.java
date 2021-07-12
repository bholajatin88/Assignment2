package com.example.assignment2;

public class Product {
    String name;
    String description;
    double price;
    int prodImg;

    public Product(String name, String description, double price, int prodImg) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.prodImg = prodImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        this.price = price;
    }

    public int getProdImg() {
        return prodImg;
    }

    public void setProdImg(int prodImg) {
        this.prodImg = prodImg;
    }
}
