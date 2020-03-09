package ru.cft.service;

import ru.cft.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarsByOwnerId(Long id);

    List<Car> getAllCars();

    void addCar(Car car);

    void deleteCar(Car car);

    void updateCar(Car car);
}
