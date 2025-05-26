package com.roger.workshopspringbootjpa.repositories;

import com.roger.workshopspringbootjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
