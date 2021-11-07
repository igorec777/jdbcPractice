package repository;

import connectorService.FlywayService;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static properties.DataSourceParams.*;


public class BaseRepositoryTest {


    private final FlywayService flywayService = new FlywayService();

    public static JdbcConnectionPool connectionPool;

    @BeforeAll
    static void openConnection() {
        connectionPool = JdbcConnectionPool.create(URL, USER, PASSWORD);
    }

    @BeforeEach
    public void initDB() {
        flywayService.migrate();
    }

    @AfterEach
    public void cleanDB() {
        flywayService.clean();
    }

    @AfterAll
    static void closeConnection() {
        connectionPool.dispose();
    }

    public static JdbcConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
