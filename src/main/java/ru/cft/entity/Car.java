package ru.cft.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private LocalDate dateOfProduction;
    private String carModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public Car(){

    }

    public Car(String number, LocalDate dateOfProduction, Owner owner, String carModel) {
        this.number = number;
        this.dateOfProduction = dateOfProduction;
        this.owner = owner;
        this.carModel = carModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
