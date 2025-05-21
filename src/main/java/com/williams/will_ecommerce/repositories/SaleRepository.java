package com.williams.will_ecommerce.repositories;

import com.williams.will_ecommerce.entities.Sale;
import com.williams.will_ecommerce.entities.utils.SaleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // Buscar ventas por estado
    List<Sale> findByStatus (SaleStatus status);
}
