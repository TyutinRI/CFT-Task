package ru.cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
