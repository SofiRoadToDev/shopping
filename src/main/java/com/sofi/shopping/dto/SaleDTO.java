package com.sofi.shopping.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class SaleDTO {

    Set<CartProductDTO> pickedProducts=new HashSet<>();
}
