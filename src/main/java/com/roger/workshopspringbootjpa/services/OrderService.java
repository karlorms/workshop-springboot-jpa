package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.Order;
import com.roger.workshopspringbootjpa.repositories.OrderRepository;
import com.roger.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
