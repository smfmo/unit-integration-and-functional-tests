package io.github.smfmo.locadora.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "model")
    private String model;

    @Column(name = "daily_value")
    private Double dailyValue;

    public CarEntity() {}

    public CarEntity(String model, Double dailyValue) {
        this.model = model;
        this.dailyValue = dailyValue;
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
}
