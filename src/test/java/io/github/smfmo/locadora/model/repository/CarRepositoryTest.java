package io.github.smfmo.locadora.model.repository;

import io.github.smfmo.locadora.entity.CarEntity;
import io.github.smfmo.locadora.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CarRepositoryTest {

    final CarRepository repository;
    CarEntity car;

    @Autowired
    public CarRepositoryTest(CarRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void createCar() {
        car = new CarEntity("Sedan", 200.0, 2020);
    }

    @Test
    @DisplayName("Este método deve persistir um objeto Car na base dados corretamente.")
    void mustSaveCar() {
        CarEntity car = new CarEntity("Civic", 100.0, 2015);

        repository.save(car);

        assertNotNull(car.getId());
    }

    @Test
    @DisplayName("Este método deve buscar um carro pelo Id")
    void mustSearchCarById() {
        CarEntity entitySaved = repository.save(car);

        Optional<CarEntity> entityFound = repository.findById(entitySaved.getId());

        assertThat(entityFound).isPresent();
        assertThat(entityFound.get().getModel()).isEqualTo("Sedan");
        assertThat(entityFound.get().getYear()).isEqualTo(2020);
    }

    @Test
    void mustUpdateCar() {
        CarEntity entitySaved = repository.save(car);

        int updatedYear = 2021;
        double updatedDailyValue = 150.0;

        entitySaved.setYear(updatedYear);
        entitySaved.setDailyValue(updatedDailyValue);
        CarEntity entityUpdated = repository.save(entitySaved);

        assertThat(entityUpdated.getYear()).isEqualTo(updatedYear);
        assertThat(entityUpdated.getDailyValue()).isEqualTo(updatedDailyValue);
    }

    @Test
    @DisplayName("Este método deve excluir o carro do banco de dados.")
    void mustDeleteCar() {
        CarEntity entity = repository.save(car);

        repository.deleteById(entity.getId());

        Optional<CarEntity> entityFound = repository.findById(entity.getId());

        assertThat(entityFound).isEmpty();
    }
}
