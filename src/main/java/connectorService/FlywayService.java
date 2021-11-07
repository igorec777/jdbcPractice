package connectorService;

import org.flywaydb.core.Flyway;

import static properties.DataSourceParams.*;


public class FlywayService {

    private Flyway flyway;

    public FlywayService() {
        init();
    }

    public void migrate() {
        flyway.migrate();
    }

    public void clean() {
        flyway.clean();
    }

    private void init() {
        flyway = Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .locations(MIGRATIONS_LOCATION)
                .load();
    }
}
