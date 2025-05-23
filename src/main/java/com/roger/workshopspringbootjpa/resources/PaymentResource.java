package com.roger.workshopspringbootjpa.resources;

import com.roger.workshopspringbootjpa.entities.Payment;
import com.roger.workshopspringbootjpa.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<Iterable<Payment>> findAll(){
        return ResponseEntity.ok().body(paymentService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById (@PathVariable Long id){
        return ResponseEntity.ok().body(paymentService.findById(id));
    }
}
