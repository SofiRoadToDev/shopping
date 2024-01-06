package com.sofi.shopping.repositories;

import com.sofi.shopping.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByName(String name);
}
