package com.williams.will_ecommerce.controllers;

import com.williams.will_ecommerce.entities.Car;
import com.williams.will_ecommerce.entities.utils.FuelType;
import com.williams.will_ecommerce.entities.utils.Status;
import com.williams.will_ecommerce.services.CarServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final Logger log = LoggerFactory.getLogger(CarController.class);

    private CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping
    public List<Car> findAll(){
        log.info("REST request to find all cars");
        return this.carServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        log.info("REST request to find one car");

        Optional<Car> carOpt = this.carServiceImpl.findById(id);

        return carOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar coches por número de puertas
    @GetMapping("/doors/{doors}")
    public List<Car> findByDoors(@PathVariable Integer doors) {
        log.info("REST request to find car by doors");

        return this.carServiceImpl.findByDoors(doors);
    }

    // Buscar coches por fabricante
    @GetMapping("/manufacturer/{manufacturer}")
    public ResponseEntity<List<Car>> findByManufacturerIgnoreCase(@PathVariable String manufacturer) {
        List<Car> cars = carServiceImpl.findByManufacturerIgnoreCase(manufacturer);
        return ResponseEntity.ok(cars);
    }

    // Buscar coches por modelo
    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> findCarsByModel(@PathVariable String model) {
        List<Car> cars = carServiceImpl.findByModelIgnoreCase(model);
        return ResponseEntity.ok(cars);
    }

    // Buscar coches por tipo de combustible (fuelType debe coincidir con el enum FuelType)
    @GetMapping("/fuelType/{fuelType}")
    public ResponseEntity<List<Car>> findCarsByFuelType(@PathVariable FuelType fuelType) {
        List<Car> cars = carServiceImpl.findByFuelType(fuelType);
        return ResponseEntity.ok(cars);
    }

    // Buscar coches por estado
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Car>> findByStatus(@PathVariable Status status) {
        List<Car> cars = carServiceImpl.findByStatus(status);
        return ResponseEntity.ok(cars);
    }

    // Buscar coches por número de asientos
    @GetMapping("/seats/{seats}")
    public ResponseEntity<List<Car>> findBySeats(@PathVariable Integer seats) {
        List<Car> cars = carServiceImpl.findBySeats(seats);
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        log.info("REST request to create a new car");

        return ResponseEntity.ok(this.carServiceImpl.save(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable Long id){
        log.info("REST request to delete an existing car");

        this.carServiceImpl.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // delete all
    @DeleteMapping
    public ResponseEntity<Car> deleteAll(){
        log.info("REST request to delete all cars");

        this.carServiceImpl.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
