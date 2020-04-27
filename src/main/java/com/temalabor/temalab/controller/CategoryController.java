package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.Category;
import com.temalabor.temalab.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(value = "/categories")
    public Category newCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @GetMapping(value = "/categories")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
