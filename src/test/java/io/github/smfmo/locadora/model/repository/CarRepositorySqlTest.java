package io.github.smfmo.locadora.model.repository;

import io.github.smfmo.locadora.entity.CarEntity;
import io.github.smfmo.locadora.repository.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("Test")
public class CarRepositorySqlTest {

    final CarRepository repository;

    @Autowired
    public CarRepositorySqlTest(CarRepository repository) {
        this.repository = repository;
    }

    @Test
    @Sql("/sql/popular_database.sql")
    @DisplayName("Este método deve buscar um carro pelo modelo.")
    void mustSearchCarPerModel() {
        List<CarEntity> list = repository.findByModel("SUV");

        CarEntity car = list.getFirst();

        assertEquals(1, list.size());
        assertThat(car.getDailyValue()).isEqualTo(150.0);
        assertThat(car.getModel()).isEqualTo("SUV");
    }
}