package com.sofi.shopping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=30)
    private String name;

    @Column(length=100)
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id",nullable = true)
    private Category category;

    @Column(precision = 10,scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<SaleDetails> saleDetails=new HashSet<>();

}
