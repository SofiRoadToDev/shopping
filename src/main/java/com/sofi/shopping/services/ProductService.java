package com.sofi.shopping.services;

import com.sofi.shopping.entities.Product;
import com.sofi.shopping.exceptions.ProductNotFoundException;

import java.util.Optional;

public interface ProductService {
    Iterable<Product>getProducts();
    Optional<Product> getProductById(Long id) throws ProductNotFoundException;
    Optional<Product>getProductByName(String name) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product product,Long id) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;

}
