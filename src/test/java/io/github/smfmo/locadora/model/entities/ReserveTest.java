package io.github.smfmo.locadora.model.entities;

import io.github.smfmo.locadora.model.exceptions.InvalidReservationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ReserveTest {

    Client client;
    Car car;

    @BeforeEach
    void createObjects() {
        client = new Client("Samuel");
        car = new Car("Sedan", 100.0);
    }

    @Test
    @DisplayName("Este método deve criar um objeto de reserva com dias válidos.")
    void mustCreateReservationForValidDays() {
        // 1. Arrange
        int validDays = 5;
        // 2. Act
        Reserve reserve = new Reserve(client, car, validDays);
        // 3. Assert
        assertThat(reserve.getQuantityDays()).isEqualTo(validDays);
        assertThat(reserve.getQuantityDays()).isGreaterThan(0);
        assertThat(reserve).isNotNull();
    }

    @Test
    @DisplayName("Este método deve lançar uma exception ao tentar instanciar uma reserva com dias inválidos.")
    void mustThrowExceptionWhenCreatingReserveWithInvalidDays() {
        int invalidDays = 0;
        // Junit:
        assertThrows(InvalidReservationException.class, () -> new Reserve(client, car, invalidDays));
        // assertj:
        Throwable error = catchThrowable(() -> new Reserve(client, car, invalidDays));
        assertThat(error)
                .isInstanceOf(InvalidReservationException.class)
                .hasMessage("Invalid number of days!");
    }

    @Test
    @DisplayName("Este método deve calcular o valor da reserva a partir de dias válidos.")
    void mustCalculateTotalReservationWithValidDays() {
        Client client = new Client("Samuel");
        Car car = new Car("Civic", 100.0);
        Reserve reserve = new Reserve(client, car, 5);

        double total = reserve.calculateTotalReservation();

        assertEquals(450.0, total);
        assertTrue(reserve.getQuantityDays() > 0);
    }

    @Test
    @DisplayName("Este método deve lançar uma excessão ao tentar calcular o valor com dias inválidos")
    void mustThrowExceptionWhenTryingToCalculateTotalReservationWithInvalidDays() {
        Client client = new Client("Samuel");
        Car car = new Car("Civic", 100.0);
        Reserve reserve = new Reserve(client, car, 5);

        reserve.setQuantityDays(-1);

        // Junit:
        assertThrows(InvalidReservationException.class, reserve::calculateTotalReservation);
        // assertj:
        Throwable error = catchThrowable(reserve::calculateTotalReservation);
        assertThat(error)
                .isInstanceOf(InvalidReservationException.class)
                .hasMessage("Invalid number of days!");
    }
}
