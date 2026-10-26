package com.example.demo.Model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(    name = "item_id", nullable = false)
    private Product item;

    private int quantity;
    private double totalamount;
    private LocalDateTime createdAt;

    public Order(){

    }

    public Order(User user, Product item, int quantity, double totalamount, LocalDateTime createdAt){
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.totalamount = totalamount;
        this.createdAt = createdAt;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}



    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
    public Product getItem() {return item;}
    public void setItem(Product item) {this.item = item;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public double getTotalamount() {return totalamount;}
    public void setTotalamount(double totalamount) {this.totalamount = totalamount;}
    public LocalDateTime getCreatedat() {return createdAt;}

}
