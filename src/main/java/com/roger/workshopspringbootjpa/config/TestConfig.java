package com.roger.workshopspringbootjpa.config;

import com.roger.workshopspringbootjpa.entities.*;
import com.roger.workshopspringbootjpa.entities.enums.OrderStatus;
import com.roger.workshopspringbootjpa.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Product pr1 = new Product(null, "Product1", "Description1", 10.0, "https://imagem1.com");
        Product pr2 = new Product(null, "Product2", "Description2", 20.0, "https://imagem2.com");

        Category c1 = new Category(null, "Category1");
        Category c2 = new Category(null, "Category2");

        productRepository.saveAll(Arrays.asList(pr1, pr2));
        categoryRepository.saveAll(Arrays.asList(c1, c2));

        pr1.getCategories().add(c1);
        pr2.getCategories().add(c2);
        productRepository.saveAll(Arrays.asList(pr1, pr2));

        User u1 = new User(null, "Name1", "email1@email.com", "999999999", "123456");
        User u2 = new User(null, "Name2", "email2@gmail.com", "999999999", "123456");

        Order o1 = new Order(null, Instant.now(), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);

        Payment p1 = new Payment(null, Instant.now(), o1);
        Payment p2 = new Payment(null, Instant.now(), o2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        paymentRepository.saveAll(Arrays.asList(p1, p2));

        OrderItem or1 = new OrderItem(o1, pr1, 2, pr1.getPrice());
        OrderItem or2 = new OrderItem(o2, pr1, 3, pr1.getPrice());
        OrderItem or3 = new OrderItem(o2, pr2, 1, pr2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(or1, or2, or3));
    }
}
