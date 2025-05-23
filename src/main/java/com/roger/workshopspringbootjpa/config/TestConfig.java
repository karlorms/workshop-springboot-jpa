package com.roger.workshopspringbootjpa.config;

import com.roger.workshopspringbootjpa.entities.Order;
import com.roger.workshopspringbootjpa.entities.Payment;
import com.roger.workshopspringbootjpa.entities.User;
import com.roger.workshopspringbootjpa.repositories.OrderRepository;
import com.roger.workshopspringbootjpa.repositories.PaymentRepository;
import com.roger.workshopspringbootjpa.repositories.UserRepository;
import com.roger.workshopspringbootjpa.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Name1", "email1@email.com", "999999999", "123456");
        User u2 = new User(null, "Name2", "email2@gmail.com", "999999999", "123456");

        Order o1 = new Order(null, Instant.now(), u1);
        Order o2 = new Order(null, Instant.now(), u2);

        Payment p1 = new Payment(null, Instant.now(), o1);
        Payment p2 = new Payment(null, Instant.now(), o2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        paymentRepository.saveAll(Arrays.asList(p1, p2));
    }
}
