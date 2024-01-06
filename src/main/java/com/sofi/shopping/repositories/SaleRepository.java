package com.sofi.shopping.repositories;

import com.sofi.shopping.entities.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;

public interface SaleRepository extends CrudRepository<Sale,Long> {

    Set<Sale> getByDate(Date date);
}
