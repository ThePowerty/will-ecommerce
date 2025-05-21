package com.williams.will_ecommerce.services;

import com.williams.will_ecommerce.entities.Car;
import com.williams.will_ecommerce.entities.utils.FuelType;
import com.williams.will_ecommerce.entities.utils.Status;
import com.williams.will_ecommerce.entities.utils.Transmission;
import com.williams.will_ecommerce.entities.utils.Type;
import com.williams.will_ecommerce.repositories.CarRepository;
import com.williams.will_ecommerce.services.interfaces.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){this.carRepository = carRepository;}

    @Override
    public List<Car> findAll() {
        log.info("Executing findAll");
        return this.carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        log.info("Executing findById");
        return this.carRepository.findById(id);
    }

    @Override
    public List<Car> findByDoors(Integer doors) {
        log.info("Executing findByDoors");
        return this.carRepository.findByDoors(doors);
    }

    @Override
    public List<Car> findBySeats(Integer seats) {
        log.info("Executing findBySeats");
        return this.carRepository.findBySeats(seats);
    }

    @Override
    public List<Car> findByType(Type type) {
        log.info("Executing findByType");
        return this.carRepository.findByType(type);
    }

    @Override
    public List<Car> findByStatus(Status status) {
        log.info("Executing findByStatus");
        return this.carRepository.findByStatus(status);
    }

    @Override
    public Car saveCar(Car car) {
        log.info(car.getId() == null ? "Creating car" : "Updating car");
        return this.carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting car by id: {}", id);
        this.carRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        log.info("Deleting cars");
        this.carRepository.deleteAll();
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        log.info("Deleting list of cars by id");
        this.carRepository.deleteAllById(ids);
    }

    @Override
    public List<Car> findByManufacturerIgnoreCase(String manufacturer) {
        log.info("Executing findByManufacturerIgnoreCase");
        return this.carRepository.findByManufacturerIgnoreCase(manufacturer);
    }

    @Override
    public List<Car> findByModelIgnoreCase(String model) {
        log.info("Executing findByModelIgnoreCase");
        return this.carRepository.findByModelIgnoreCase(model);
    }

    @Override
    public List<Car> findByColor(String string) {
        log.info("Executing findByColor");
        return this.carRepository.findByColor(string);
    }

    @Override
    public List<Car> findByTransmission(Transmission transmission) {
        log.info("Executing findByTransmission");
        return this.carRepository.findByTransmission(transmission);
    }

    @Override
    public List<Car> findByFuelType(FuelType fuelType) {
        log.info("Executing findByFuelType");
        return this.carRepository.findByFuelType(fuelType);
    }
}
