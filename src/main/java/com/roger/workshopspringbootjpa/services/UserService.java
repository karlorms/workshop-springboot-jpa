package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.User;
import com.roger.workshopspringbootjpa.repositories.UserRepository;
import com.roger.workshopspringbootjpa.services.exceptions.DatabaseException;
import com.roger.workshopspringbootjpa.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try {
            User userSaved = userRepository.getReferenceById(id);
            updateData(userSaved, user);
            return userRepository.save(userSaved);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User userSaved, User user) {
        userSaved.setName(user.getName());
        userSaved.setEmail(user.getEmail());
        userSaved.setPhone(user.getPhone());
    }
}
