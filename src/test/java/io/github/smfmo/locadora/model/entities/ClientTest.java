package io.github.smfmo.locadora.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    @DisplayName("Este método deve criar um Cliente com nome.")
    void mustCreateClientWithName() {
        // 1. Arrange
        Client client = new Client("Maria");
        // 2. Act
        String name = client.getName();
        // 3. Assert
        // lib = Junit
        assertNotNull(name);
        assertTrue(name.startsWith("M"));
        assertFalse(name.length() == 100);

        // lib = assertj
        assertThat(name).isEqualTo("Maria");
        assertThat(name).isLessThan("Maria5");
        assertThat(name.length()).isLessThan(100);
        assertThat(name).contains("r");
    }

    @Test
    @DisplayName("Este método deve criar um cliente sem nome.")
    void mustCreateClientWithoutName() {
        Client client = new Client(null);

        var name = client.getName();

        assertNull(name);
    }
}
