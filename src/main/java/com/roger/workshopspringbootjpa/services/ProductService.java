package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.Product;
import com.roger.workshopspringbootjpa.repositories.ProductRepository;
import com.roger.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
