package com.example.OrderManagement.service;

import com.example.OrderManagement.model.Orders;
import com.example.OrderManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(Orders order){
        orderRepository.save(order);
    }

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order Not Found..!") );
    }

    public Orders updateOrderById(Orders order, Long id){
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order Not Found..!"));

        existingOrder.setOrderNumber(order.getOrderNumber());
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setPaymentStatus(order.getPaymentStatus());

        return orderRepository.save(existingOrder);
    }

    public String deleteOrderById(Long id){
        orderRepository.deleteById(id);
        return "order successfully deleted..!";
    }
}
