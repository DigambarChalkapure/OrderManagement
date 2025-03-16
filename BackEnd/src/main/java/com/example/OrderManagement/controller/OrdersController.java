package com.example.OrderManagement.controller;

import com.example.OrderManagement.model.Orders;
import com.example.OrderManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody Orders order){
        orderService.placeOrder(order);
        return "Order Successfully placed..!";
    }

    @GetMapping
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id){
       return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@RequestBody Orders order,@PathVariable Long id){
        return orderService.updateOrderById(order,id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        return orderService.deleteOrderById(id);
    }
}
