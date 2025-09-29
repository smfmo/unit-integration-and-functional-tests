package io.github.smfmo.locadora.model.entities;

public class Car {

    private String model;
    private Double dailyValue;

    public Car() {}

    public Car(String model, Double dailyValue) {
        this.model = model;
        this.dailyValue = dailyValue;
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

    public double calculateRentValue(int days) {
        if (days >= 5) {
            return days * dailyValue - 50;
        }
        return days * dailyValue;
    }
}
