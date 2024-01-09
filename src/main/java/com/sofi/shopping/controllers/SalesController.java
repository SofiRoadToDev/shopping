package com.sofi.shopping.controllers;

import com.sofi.shopping.dto.SaleDTO;
import com.sofi.shopping.entities.Product;
import com.sofi.shopping.entities.Sale;
import com.sofi.shopping.entities.SaleDetails;
import com.sofi.shopping.mapper.SaleMapper;
import com.sofi.shopping.services.ProductService;
import com.sofi.shopping.services.SaleService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@Log4j2
@RequestMapping("/sales")
@AllArgsConstructor
public class SalesController {

    private SaleService saleService;
    private SaleMapper saleMapper;
    private ProductService productService;
    @GetMapping()
    public List<SaleDTO> getAllSales(){
        List<Sale>sales=new ArrayList<>(saleService.getAllSales());/* Set to List-> new ArrayList(set)*/
        return saleMapper.saleListToSaleDTOList(sales);
    }

    @PostMapping()
    public SaleDTO createSale(SaleDTO saleDTO){
        Set<SaleDetails> saleDetails=new HashSet<>();
                saleDTO
                .getPickedProducts()
                .forEach(p->{
                    Product product=productService.getProductById(p.getId()).get();
                    SaleDetails detail=new SaleDetails();
                    detail.setQuantity(p.getQuantity());
                    detail.setProduct(product);
                    saleDetails.add(detail);
                });
        return null;
    }

}
