package ru.cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.entity.Car;
import ru.cft.entity.Owner;
import ru.cft.repository.OwnerRepository;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void updateOwner(Owner owner) {

    }
}
