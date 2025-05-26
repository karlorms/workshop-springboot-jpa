package com.roger.workshopspringbootjpa.services;

import com.roger.workshopspringbootjpa.entities.Category;
import com.roger.workshopspringbootjpa.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){return categoryRepository.findAll();}

    public Category findById(Long id){return categoryRepository.findById(id).get();}
}
