package ru.cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
