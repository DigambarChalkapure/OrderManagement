package com.example.OrderManagement.service;

import com.example.OrderManagement.model.Customer;
import com.example.OrderManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer){
       customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("CUSTOMER NOT FOUND..!!"));
    }

    public List<Customer>getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long id,Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getCustomerId())
                .orElseThrow(()->new RuntimeException("Customer Not Found..!!"));

        existingCustomer.setCustomerId(customer.getCustomerId());
        existingCustomer.setF_name(customer.getF_name());
        existingCustomer.setL_name(customer.getL_name());
        existingCustomer.setUsername(customer.getUsername());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setGender(customer.getGender());

        return customerRepository.save(existingCustomer);
    }

    public String deleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "Customer Successfully Deleted..!!";
    }
}
