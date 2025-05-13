package com.williams.will_ecommerce.entities;

import com.williams.will_ecommerce.entities.utils.FuelType;
import com.williams.will_ecommerce.entities.utils.Status;
import com.williams.will_ecommerce.entities.utils.Transmission;
import com.williams.will_ecommerce.entities.utils.Type;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private LocalDate year;
    private String color;
    private String engine_type;
    private Transmission transmission;
    private Integer kilometers;
    private FuelType fuelType;
    private Integer doors;
    private Integer seats;
    private Type type;
    private Status status;
    private Double price;
    private String description;

    public Car() {
    }

    public Car(String manufacturer, String model, LocalDate year, String color, String engine_type, Transmission transmission, Integer kilometers, FuelType fuelType, Integer doors, Integer seats, Type type, Double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine_type = engine_type;
        this.transmission = transmission;
        this.kilometers = kilometers;
        this.fuelType = fuelType;
        this.doors = doors;
        this.seats = seats;
        this.type = type;
        this.price = price;
        this.status = Status.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
