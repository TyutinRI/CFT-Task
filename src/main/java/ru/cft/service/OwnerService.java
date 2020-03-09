package ru.cft.service;

import ru.cft.entity.Car;
import ru.cft.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwners();

    boolean addOwner(Owner owner);

    void deleteOwner(Long id);

    void updateOwner(Owner owner);
}
