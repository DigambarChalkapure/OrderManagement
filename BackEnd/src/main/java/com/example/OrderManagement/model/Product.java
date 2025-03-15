package com.example.OrderManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;
    @Column(name = "name",nullable = false)
    private String productName;
    @Column(name = "brand",nullable = false)
    private String brand;
    @Column(name = "category",nullable = false)
    private String category;
    @Column(name = "price",nullable = false)
    private double price;
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;

    Product(){

    }

    public Product(String productName, String brand, String category, double price, List<Orders> orders) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.orders = orders;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
