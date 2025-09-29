package io.github.smfmo.locadora.model.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ReserveTest {

    @Test
    @DisplayName("Este método deve criar um objeto de reserva com dias válidos.")
    void mustCreateReservationForValidDays() {
        // 1. Arrange
        int validDays = 5;
        // 2. Act
        Reserve reserve = new Reserve(
                new Client("Samuel"),
                new Car("Sedan", 100.0),
                validDays
        );
        // 3. Assert
        assertThat(reserve.getQuantityDays()).isEqualTo(validDays);
        assertThat(reserve.getQuantityDays()).isGreaterThan(0);
    }

}
