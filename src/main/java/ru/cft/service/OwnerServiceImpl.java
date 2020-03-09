package ru.cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    /**
     * Метод для сохранения {@link Owner} в базе данных.
     * @param owner сохраняемый в базе данных {@link Owner}
     * @return {@code true} если строки не пустые и содержат не только пробельные символы.
     */
    @Override
    public boolean addOwner(Owner owner) {
        if (!owner.getFirstName().matches("(.*)\\S(.*)")
                || !owner.getLastName().matches("(.*)\\S(.*)")) {
            return false;
        }
        ownerRepository.save(owner);
        return true;
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

}
