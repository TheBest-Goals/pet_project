package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "roblox_items")
public class RobloxItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column( name = "price", nullable = false)
    private double price;

    @Column( name = "stock", nullable = false)
    private int stock;

    public RobloxItem(){

    }

    public RobloxItem(String title, double price, int stock){
        this.name = title;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}