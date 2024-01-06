package com.sofi.shopping.services;

import com.sofi.shopping.entities.Category;

import java.util.Optional;

public interface CategoryService {

    Iterable<Category> getll();
    Optional<Category> getByName(String name);
    Optional <Category>getById(Long id);
    void deleteCategory(Long id);
    Category createCategory(Category category);
    Category updateCategory(Category category,Long id);

}
