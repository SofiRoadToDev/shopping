package com.sofi.shopping.services;

import com.sofi.shopping.entities.Sale;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface SaleService {
    Set<Sale> getByDate(Date date) throws RuntimeException;
    Optional<Sale>getById(Long id)throws RuntimeException;


}
