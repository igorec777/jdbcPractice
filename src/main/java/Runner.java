import connectorService.FlywayService;

public class Runner {
    public static void main(String[] args) {
        FlywayService flywayService = new FlywayService();
        flywayService.migrate();

        //some operations with DB

        flywayService.clean();
    }
}
