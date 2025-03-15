package com.example.OrderManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long customerId;
    @Column(name = "firstname",nullable = false)
    private String f_name;
    @Column(name = "lastname",nullable = false)
    private String l_name;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "number",nullable = false,unique = true)
    private Long phoneNumber;
    @Column(name = "gender",nullable = false)
    private String gender;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    Customer(){

    }

    public Customer(String f_name, String l_name, String username, Long phoneNumber, String gender, List<Orders> orders) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.orders = orders;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
