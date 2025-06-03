package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.Payment;
import com.roger.workshopspringbootjpa.repositories.PaymentRepository;
import com.roger.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
