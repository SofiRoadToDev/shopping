package com.sofi.shopping.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class SaleDTO {

    private Set<CartProductDTO> pickedProducts=new HashSet<>();

    private BigDecimal totalPrice;
}
