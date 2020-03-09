package ru.cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.cft.entity.Car;

import javax.transaction.Transactional;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "DELETE FROM cars c WHERE c.owner_id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteByOwnerId(@Param("id") Long id);

    List<Car> findByOwnerId(Long id);
}
