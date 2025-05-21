package com.williams.will_ecommerce.services;

import com.williams.will_ecommerce.entities.Sale;
import com.williams.will_ecommerce.entities.utils.SaleStatus;
import com.williams.will_ecommerce.repositories.SaleRepository;
import com.williams.will_ecommerce.services.interfaces.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    private final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        log.info("Executing findAll");
        return this.saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        log.info("Executing findBy id");
        return this.saleRepository.findById(id);
    }

    @Override
    public Sale saveSale(Sale sale) {
        log.info(sale.getId() == null ? "Creating sale" : "Updating sale");
        return this.saleRepository.save(sale);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Executing delete sale by id: {}", id);
        this.saleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Executing deleteAll");
        this.saleRepository.deleteAll();
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        log.info("Executing deleteAllById");
        this.saleRepository.deleteAllById(ids);
    }

    @Override
    public List<Sale> findByStatus(SaleStatus status) {
        log.info("Executing findByStatus");
        return this.saleRepository.findByStatus(status);
    }
}
