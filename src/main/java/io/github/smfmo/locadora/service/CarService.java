package io.github.smfmo.locadora.service;

import io.github.smfmo.locadora.entity.CarEntity;
import io.github.smfmo.locadora.exception.InvalidDailyValueException;
import io.github.smfmo.locadora.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public CarEntity getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }

    public List<CarEntity> getAll() {
        return repository.findAll();
    }

    public CarEntity save(CarEntity car) {
        validateDailyValue(car.getDailyValue());
        return repository.save(car);
    }

    public CarEntity update(UUID id, CarEntity updatedCar) {
        CarEntity carSaved = getById(id);

        validateDailyValue(updatedCar.getDailyValue());

        carSaved.setModel(updatedCar.getModel());
        carSaved.setDailyValue(updatedCar.getDailyValue());
        carSaved.setYear(updatedCar.getYear());

        return repository.save(carSaved);
    }

    public void delete(UUID id) {
        getById(id);
        repository.deleteById(id);
    }

    private void validateDailyValue(double dailyValue) {
        if (dailyValue <= 0) {
            throw new InvalidDailyValueException("Daily value is invalid.");
        }
    }
}
