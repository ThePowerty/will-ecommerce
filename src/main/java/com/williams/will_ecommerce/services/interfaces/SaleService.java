package com.williams.will_ecommerce.services.interfaces;

import com.williams.will_ecommerce.entities.Sale;
import com.williams.will_ecommerce.entities.utils.SaleStatus;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    Sale saveSale(Sale sale);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllById(List<Long> ids);

    List<Sale> findByStatus(SaleStatus status);
}
