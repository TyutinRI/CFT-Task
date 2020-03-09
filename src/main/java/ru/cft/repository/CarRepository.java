package ru.cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.cft.entity.Car;

import javax.transaction.Transactional;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    /**
     * Метод для удаления всех машин с id владельца равным параметру
     * @param id - id владельца
     */
    @Query(value = "DELETE FROM cars c WHERE c.owner_id = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteByOwnerId(@Param("id") Long id);

    /**
     * Метод для получения списка всех машин с id владельца равным параметру
     * @param id - id владельца
     */
    List<Car> findByOwnerId(Long id);
}
