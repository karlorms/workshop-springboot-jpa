package com.roger.workshopspringbootjpa.repositories;

import com.roger.workshopspringbootjpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
