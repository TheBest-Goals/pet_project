package com.example.demo.dto;

public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private int stock;
    private String type;
    private Long sellerId;
    private String sellerName;

    public ProductDto(){

    }

    public ProductDto(Long id, String name, double price, int stock, String type, Long sellerId, String sellerName){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
    }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }
    public void setType(String type) { this.type = type; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }

    public Long   getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int    getStock() { return stock; }
    public String getType() { return type; }
    public Long   getSellerId() { return sellerId; }
    public String getSellerName() { return sellerName; }
}