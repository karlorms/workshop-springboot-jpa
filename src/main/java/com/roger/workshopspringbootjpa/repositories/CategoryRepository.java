package com.roger.workshopspringbootjpa.repositories;

import com.roger.workshopspringbootjpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
