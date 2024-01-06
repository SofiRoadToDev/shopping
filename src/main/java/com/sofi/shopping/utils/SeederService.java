package com.sofi.shopping.utils;

import com.sofi.shopping.entities.Category;
import com.sofi.shopping.entities.Product;
import com.sofi.shopping.repositories.CategoryRepository;
import com.sofi.shopping.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
@AllArgsConstructor
public class SeederService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        Category category=new Category();
        category.setName("tazas");
        category.setDescription("tazas y vasos");
        categoryRepository.save(category);


        Product product=new Product();
        product.setName("taza de ceramica");
        product.setPrice(new BigDecimal(2500));
        product.setDescription("tza personalizadade ceramica con colores vibrantes");
        product.setCategory(categoryRepository.findByName("tazas").get());
        productRepository.save(product);
    }

}
