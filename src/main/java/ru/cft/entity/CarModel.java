package ru.cft.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producerFirm;

    public CarModel(){

    }

    public CarModel(String producerFirm) {
        this.producerFirm = producerFirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducerFirm() {
        return producerFirm;
    }

    public void setProducerFirm(String producerFirm) {
        this.producerFirm = producerFirm;
    }
}
