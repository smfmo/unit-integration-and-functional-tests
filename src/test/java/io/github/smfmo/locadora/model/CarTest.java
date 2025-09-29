package io.github.smfmo.locadora.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Este método deve calcular o valor do aluguel, multiplicando o valor da diária pelo total de dias.")
    void mustCalculateRentalValue() {
        // 1. Scenario = Arrange
        Car car = new Car("Sedan", 100.0);
        // 2. Execution = Act
        double total = car.calculateRentValue(3);
        // 3. Verification = Assert
        Assertions.assertEquals(300.0, total);
    }

    @Test
    @DisplayName("Este método deve calcular o valor do aluguel com desconto. (Acima de 5 dias = desconto de R$ 50.00)")
    void mustCalculateDiscountedRentalValue() {
        Car car = new Car("Sedan", 100.0);
        int quantityDays = 5;

        double total = car.calculateRentValue(quantityDays);

        Assertions.assertEquals(450.0, total);
    }
}
