package com.sofi.shopping.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date dateAndTime;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL,orphanRemoval = true)
    Set<SaleDetails> saleDetails=new HashSet<>();


}
