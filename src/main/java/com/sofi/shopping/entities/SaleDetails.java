package com.sofi.shopping.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Integer quantity;


}
