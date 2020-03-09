package ru.cft.service;

import ru.cft.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getAllCarsByOwnerId(Long id);

    Car getById(Long id);

    boolean addCar(Car car);

    void deleteCar(Long id);

    void deleteCarByOwnerId(Long id);

}
