package com.sofi.shopping.services;

import com.sofi.shopping.entities.Sale;
import com.sofi.shopping.exceptions.SaleNotFoundException;
import com.sofi.shopping.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
@AllArgsConstructor
public class SaleServiceImpl implements SaleService{

    private SaleRepository saleRepository;
    @Override
    public Set<Sale> getByDate(Date date) throws RuntimeException {
        return saleRepository.getByDate(date);
    }

    @Override
    public Optional<Sale> getById(Long id) throws RuntimeException {
        return saleRepository.findById(id).or(()->{
            throw new SaleNotFoundException(String.format("Sale id %s is not in our database",id));
        });
    }
}
