package io.github.smfmo.locadora.model.repository;

import io.github.smfmo.locadora.entity.CarEntity;
import io.github.smfmo.locadora.repository.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CarRepositoryTest {

    final CarRepository repository;

    @Autowired
    public CarRepositoryTest(CarRepository repository) {
        this.repository = repository;
    }

    @Test
    @DisplayName("Este método deve persistir um objeto Car na base dados corretamente.")
    void mustSaveCar() {
        CarEntity car = new CarEntity("Civic", 100.0);

        repository.save(car);

        assertNotNull(car.getId());
    }
}
