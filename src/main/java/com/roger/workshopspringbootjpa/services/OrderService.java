package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.Order;
import com.roger.workshopspringbootjpa.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(@PathVariable Long id){
        return orderRepository.findById(id).get();
    }
}
