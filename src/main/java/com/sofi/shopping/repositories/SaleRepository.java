package com.sofi.shopping.repositories;

import com.sofi.shopping.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale,Long> {
}
