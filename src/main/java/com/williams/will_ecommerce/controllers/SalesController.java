package com.williams.will_ecommerce.controllers;

import com.williams.will_ecommerce.entities.Sale;
import com.williams.will_ecommerce.entities.utils.SaleStatus;
import com.williams.will_ecommerce.services.SaleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final Logger log = LoggerFactory.getLogger(SalesController.class);

    private SaleServiceImpl saleService;

    public SalesController(SaleServiceImpl saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll(){
        log.info("REST request to find all sales");
        List<Sale> sales = this.saleService.findAll();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id){
        log.info("REST request to find one sale");

        Optional<Sale> saleOpt = this.saleService.findById(id);

        return saleOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{saleStatus}")
    public ResponseEntity<List<Sale>> findByStatus(@PathVariable SaleStatus saleStatus){
        log.info("REST request to find sales by Status");
        List<Sale> sales = this.saleService.findByStatus(saleStatus);
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sale> saveSale(@RequestBody Sale sale){
        log.info("REST request to save a sale");

        return ResponseEntity.ok(this.saleService.saveSale(sale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sale> delete(@PathVariable Long id){
        log.info("REST request to delete an existing sale");

        this.saleService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Sale> deleteAll(){
        log.info("REST request to delete all sales");

        this.saleService.deleteAll();;

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/many/{ids}")
    public ResponseEntity<Sale> deleteAllById(@PathVariable List<Long> ids) {
        log.info("REST request to delete sales by list");

        this.saleService.deleteAllById(ids);

        return ResponseEntity.noContent().build();
    }

}
