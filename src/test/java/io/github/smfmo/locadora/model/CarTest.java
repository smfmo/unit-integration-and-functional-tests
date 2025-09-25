package io.github.smfmo.locadora.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Este método deve calcular o valor do aluguel, multiplicando o valor da diária pelo total de dias.")
    void mustCalculateRentalValue() {
        Car car = new Car("Sedan", 100.0);
        double total = car.calculateRentValue(3);

        Assertions.assertEquals(300.0, total);
    }

}
