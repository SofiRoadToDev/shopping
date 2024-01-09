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

    List<SaleDTO>saleListToSaleDTOList(List<Sale>sales);

    List<Sale>saleDTOListToSaleList(List<SaleDTO>saleDTOS);
    Product productToCartProductDTO(CartProductDTO productDTO);
    CartProductDTO productToCarProductDTO(Product product);
}
