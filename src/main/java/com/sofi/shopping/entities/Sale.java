package com.sofi.shopping.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @OneToMany(mappedBy = "sale",cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
    Set<SaleDetails> saleDetails=new HashSet<>();

    @Column(precision = 10,scale = 2)
    private BigDecimal totalPrice;


}
