package com.williams.will_ecommerce.repositories;

import com.williams.will_ecommerce.entities.Car;
import com.williams.will_ecommerce.entities.utils.FuelType;
import com.williams.will_ecommerce.entities.utils.Status;
import com.williams.will_ecommerce.entities.utils.Transmission;
import com.williams.will_ecommerce.entities.utils.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Buscar coches por fabricante (ignora mayúsculas/minúsculas)
    List<Car> findByManufacturerIgnoreCase(String manufacturer);

    // Buscar coches por modelo (ignora mayúsculas/minúsculas)
    List<Car> findByModelIgnoreCase(String model);

    // Buscar coches por el color
    List<Car> findByColor(String string);

    // Buscar coches por tipo de transmisión (manual o automático)
    List<Car> findByTransmission (Transmission transmission);

    // Buscar coches por tipo de combustible
    List<Car> findByFuelType(FuelType fuelType);

    // Buscar coches por número de puertas
    List<Car> findByDoors(Integer doors);

    // Buscar coches por número de asientos
    List<Car> findBySeats(Integer seats);

    // Buscar coches por tipo (por ejemplo: nuevo, usado, etc.)
    List<Car> findByType(Type type);

    // Buscar coches por estado (por ejemplo: disponible, vendido, en mantenimiento, etc.)
    List<Car> findByStatus(Status status);

}
