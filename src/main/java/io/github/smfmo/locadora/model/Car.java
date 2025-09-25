package io.github.smfmo.locadora.model;

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
        return days * dailyValue;
    }
}
