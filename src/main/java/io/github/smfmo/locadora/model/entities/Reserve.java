package io.github.smfmo.locadora.model.entities;

import io.github.smfmo.locadora.model.exceptions.InvalidReservationException;

public class Reserve {

    private Client client;
    private Car car;
    private Integer quantityDays;

    public Reserve() {}

    public Reserve(Client client, Car car, Integer quantityDays) {
        if (quantityDays <= 0) {
            validateReservation(quantityDays);
        }
        this.client = client;
        this.car = car;
        this.quantityDays = quantityDays;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Integer getQuantityDays() {
        return quantityDays;
    }
    public void setQuantityDays(Integer quantityDays) {
        if (quantityDays <= 0) {
            validateReservation(quantityDays);
        }
        this.quantityDays = quantityDays;
    }

    public double calculateTotalReservation() {
        if (quantityDays <= 0) {
            validateReservation(quantityDays);
        }
        return car.calculateRentValue(quantityDays);
    }

    private void validateReservation(int days) {
        if (days <= 0) {
            throw new InvalidReservationException("Invalid number of days!");
        }
    }
}
