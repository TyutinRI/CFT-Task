package ru.cft.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private Date dateOfProduction;

    private String carModel;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public Car(){

    }

    public Car(String number, Date dateOfProduction, Owner owner, String carModel) {
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

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                ", carModel='" + carModel + '\'' +
                ", owner=" + owner +
                '}';
    }
}
