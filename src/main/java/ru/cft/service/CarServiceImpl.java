package ru.cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.entity.Car;
import ru.cft.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAllCarsByOwnerId(Long id) {
        return carRepository.findByOwnerId(id);
    }

    /**
     * Метод для сохранения {@link Car} в базе данных.
     * @param car сохраняемый в базе данных {@link Car}
     * @return {@code true} если строки не пустые и содержат не только пробельные символы.
     */
    @Override
    public boolean addCar(Car car) {
        if (!car.getNumber().matches("(.*)\\S(.*)")
                || !car.getCarModel().matches("(.*)\\S(.*)")) {
            return false;
        }
        carRepository.save(car);
        return true;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteCarByOwnerId(Long id) {
        carRepository.deleteByOwnerId(id);
    }
}
