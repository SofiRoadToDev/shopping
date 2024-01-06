package com.sofi.shopping.controllers;

import com.sofi.shopping.entities.Product;
import com.sofi.shopping.exceptions.ProductNotFoundException;
import com.sofi.shopping.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@Log4j2
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;

    @GetMapping()
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable String name)throws ProductNotFoundException{
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id)throws ProductNotFoundException{
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody Product product,@PathVariable Long id)throws ProductNotFoundException {
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }

    @PostMapping()
    public ResponseEntity addProduct(@RequestBody Product product){
        return new ResponseEntity(productService.createProduct(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        log.info(String.format("id %s entered the controller for deleting",id));
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfuly");
    }


}
