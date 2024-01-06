package com.sofi.shopping.services;

import com.sofi.shopping.entities.Product;
import com.sofi.shopping.exceptions.ProductNotFoundException;
import com.sofi.shopping.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Log4j2
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) throws ProductNotFoundException{
      return productRepository.findById(id).or(()->{
          throw new ProductNotFoundException(String.format("Product id %s not found",id));
      });

    }

    @Override
    public Optional<Product> getProductByName(String name) throws ProductNotFoundException {
        return productRepository.findByName(name).or(()->{
            throw new ProductNotFoundException(String.format("Product name %s not found",name));
        });
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) throws ProductNotFoundException {
        Product prod=productRepository.findById(id).orElse(null);
        if(prod!=null){
            log.info("updating");
            BeanUtils.copyProperties(product,prod,"id");
            productRepository.save(prod);
        }else{
            log.warn("null object for updating");
            throw new ProductNotFoundException(String.format("The product id: %s doesn't exist",id));
        }
        return prod;
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException{
        Product prod=productRepository.findById(id).orElse(null);
        if(prod==null){
            log.warn(String.format("id %s doesn't exist, not possible to delete. Service"));
            throw new ProductNotFoundException(String.format("The product id: %s doesn't exist",id));
        }else{
            productRepository.deleteById(id);
        }
    }
}
