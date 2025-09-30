package io.github.smfmo.locadora.model;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    static Connection connection;

    @BeforeAll
    static void createDatabase() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        connection.createStatement().execute("CREATE TABLE users (id INT, name VARCHAR)");
    }

    @BeforeEach
    void insertUserTest() throws Exception {
        connection.createStatement().execute("insert into users (id, name) values (1, 'Samuel')");
    }

    @Test
    // @Disabled
    void testUsersExists() throws Exception {
        ResultSet result = connection.createStatement().executeQuery("select * from users where id = 1");

        assertTrue(result.next());
    }

    @AfterAll
    static void closeConnection() throws Exception {
        connection.close();
    }
}
