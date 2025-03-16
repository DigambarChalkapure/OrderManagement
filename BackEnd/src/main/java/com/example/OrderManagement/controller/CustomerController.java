package com.example.OrderManagement.controller;

import com.example.OrderManagement.model.Customer;
import com.example.OrderManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/register")
    public String customerCreate(@RequestBody Customer customer){
         customerService.createCustomer(customer);
         return "User Created Successfully..!!";
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateUser(@RequestBody Customer customer,@PathVariable Long id){
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
