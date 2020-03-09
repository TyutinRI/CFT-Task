package ru.cft.service;

import ru.cft.entity.Car;
import ru.cft.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwners();

    Owner getById(Long id);

    boolean addOwner(Owner owner);

    void deleteOwner(Long id);


}
