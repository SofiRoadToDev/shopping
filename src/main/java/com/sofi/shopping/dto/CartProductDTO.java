package com.sofi.shopping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CartProductDTO {


    @NotNull(message = "Id is mandatory")
    private Long id;

    @NotBlank(message = "Product name must be provided")
    private String name;

    @NotNull(message = "quantity must be provided")
    private int quantity;
}
