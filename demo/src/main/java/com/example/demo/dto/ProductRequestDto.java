package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDto {
    @NotBlank(message = "name can't be empty")
    private String name;

    @Min(value = 1, message = "price should be greater than 1")
    private double price;

    @Min(value = 1, message = "the stock must be be at least 1")
    private int stock;

    @NotBlank
    private String type;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
