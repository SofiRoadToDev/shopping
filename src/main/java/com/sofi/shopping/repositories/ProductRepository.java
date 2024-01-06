package com.sofi.shopping.repositories;

import com.sofi.shopping.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    Optional<Product> findByName(String name);

}
