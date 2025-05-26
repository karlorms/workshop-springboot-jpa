package com.roger.workshopspringbootjpa.config;

import com.roger.workshopspringbootjpa.entities.Category;
import com.roger.workshopspringbootjpa.entities.Order;
import com.roger.workshopspringbootjpa.entities.Payment;
import com.roger.workshopspringbootjpa.entities.User;
import com.roger.workshopspringbootjpa.entities.enums.OrderStatus;
import com.roger.workshopspringbootjpa.repositories.CategoryRepository;
import com.roger.workshopspringbootjpa.repositories.OrderRepository;
import com.roger.workshopspringbootjpa.repositories.PaymentRepository;
import com.roger.workshopspringbootjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "Category1");
        Category c2 = new Category(null, "Category2");

        categoryRepository.saveAll(Arrays.asList(c1, c2));

        User u1 = new User(null, "Name1", "email1@email.com", "999999999", "123456");
        User u2 = new User(null, "Name2", "email2@gmail.com", "999999999", "123456");

        Order o1 = new Order(null, Instant.now(), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);

        Payment p1 = new Payment(null, Instant.now(), o1);
        Payment p2 = new Payment(null, Instant.now(), o2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        paymentRepository.saveAll(Arrays.asList(p1, p2));
    }
}
