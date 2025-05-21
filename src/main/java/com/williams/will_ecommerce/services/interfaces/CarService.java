package com.williams.will_ecommerce.services.interfaces;

import com.williams.will_ecommerce.entities.Car;
import com.williams.will_ecommerce.entities.utils.FuelType;
import com.williams.will_ecommerce.entities.utils.Status;
import com.williams.will_ecommerce.entities.utils.Transmission;
import com.williams.will_ecommerce.entities.utils.Type;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> findAll();

    Optional<Car> findById(Long id);

    Car saveCar(Car car);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllById(List<Long> ids);

    List<Car> findByManufacturerIgnoreCase(String manufacturer);

    List<Car> findByModelIgnoreCase(String model);

    List<Car> findByColor(String string);

    List<Car> findByTransmission (Transmission transmission);

    List<Car> findByFuelType(FuelType fuelType);

    List<Car> findByDoors(Integer doors);

    List<Car> findBySeats(Integer seats);

    List<Car> findByType(Type type);

    List<Car> findByStatus(Status status);

}