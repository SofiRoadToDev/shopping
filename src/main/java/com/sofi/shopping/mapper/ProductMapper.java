package com.sofi.shopping.mapper;

import com.sofi.shopping.dto.CartProductDTO;
import com.sofi.shopping.entities.Product;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Set<Product> productDTOListToProductList(Set<CartProductDTO>list);
    Set<CartProductDTO>productListToProductDTOList(Set<Product>products);
}
