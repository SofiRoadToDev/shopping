package com.sofi.shopping.utils;

import com.sofi.shopping.entities.Category;
import com.sofi.shopping.entities.Product;
import com.sofi.shopping.entities.Sale;
import com.sofi.shopping.entities.SaleDetails;
import com.sofi.shopping.repositories.CategoryRepository;
import com.sofi.shopping.repositories.ProductRepository;
import com.sofi.shopping.repositories.SaleDetailsRepository;
import com.sofi.shopping.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
@Log4j2
@AllArgsConstructor
public class SeederService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SaleRepository saleRepository;
    private SaleDetailsRepository saleDetailsRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        Category category=new Category();
        category.setName("tazas");
        category.setDescription("tazas y vasos");
        categoryRepository.save(category);

        Category catTextiles=new Category();
        catTextiles.setName("textiles");
        catTextiles.setDescription("ropa en gral");
        categoryRepository.save(catTextiles);


        Product product=new Product();
        product.setName("taza de ceramica");
        product.setPrice(new BigDecimal(2500));
        product.setDescription("tza personalizadade ceramica con colores vibrantes");
        product.setCategory(categoryRepository.findByName("tazas").get());
        productRepository.save(product);

        Product remera=new Product();
        remera.setName("remera blanca");
        remera.setPrice(new BigDecimal(2500));
        remera.setDescription("Remera de poliéster sublimada");
        remera.setCategory(categoryRepository.findByName("textiles").get());
        Product savedRemera=productRepository.save(remera);


        Sale sale=new Sale();
        sale.setTotalPrice(new BigDecimal(40000));
        sale.setDateTime(Timestamp.from(Instant.now()));
        /*SaleDetails the Union Table*/
        SaleDetails saleDetails=new SaleDetails();
        saleDetails.setProduct(savedRemera);// asignamos la entidad ya persistida, debe tener el id
        saleDetails.setQuantity(2);
        /* Se deben asignar dos entidades ya guardadas, que contengan su ID*/
        Sale storedSale=saleRepository.save(sale);
        saleDetails.setSale(storedSale);
        saleDetailsRepository.save(saleDetails);

    }

}
