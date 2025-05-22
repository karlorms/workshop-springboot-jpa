package com.roger.workshopspringbootjpa.repositories;

import com.roger.workshopspringbootjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
