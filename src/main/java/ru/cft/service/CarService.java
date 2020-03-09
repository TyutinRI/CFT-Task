package ru.cft.service;

import ru.cft.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    boolean addCar(Car car);

    void deleteCar(Long id);

    void deleteCarByOwnerId(Long id);

    Car findById(Long id);
}
