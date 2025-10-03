package io.github.smfmo.locadora.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String model;
    private Double dailyValue;
    private Integer year;

    public CarEntity() {}

    public CarEntity(String model, Double dailyValue, Integer year) {
        this.model = model;
        this.dailyValue = dailyValue;
        this.year = year;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Double getDailyValue() {
        return dailyValue;
    }
    public void setDailyValue(Double dailyValue) {
        this.dailyValue = dailyValue;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}
