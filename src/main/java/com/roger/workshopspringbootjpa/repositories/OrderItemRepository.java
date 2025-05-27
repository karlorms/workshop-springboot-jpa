package com.roger.workshopspringbootjpa.repositories;

import com.roger.workshopspringbootjpa.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
