package com.sofi.shopping.services;

import com.sofi.shopping.entities.Category;
import com.sofi.shopping.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> getll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return null;
    }
}
