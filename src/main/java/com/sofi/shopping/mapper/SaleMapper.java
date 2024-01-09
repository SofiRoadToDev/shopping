package com.sofi.shopping.mapper;

import com.sofi.shopping.dto.CartProductDTO;
import com.sofi.shopping.dto.SaleDTO;
import com.sofi.shopping.entities.Product;
import com.sofi.shopping.entities.Sale;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale saleDTOtoSale(SaleDTO saleDTO);
    SaleDTO saleToSaleDTO(Sale sale);

    Product productToCartProductDTO(CartProductDTO productDTO);
    CartProductDTO productToCarProductDTO(Product product);
}
