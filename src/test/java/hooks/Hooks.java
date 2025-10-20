package hooks;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.restassured.RestAssured;
import utils.ApiConfig;

public class Hooks {

    @BeforeAll
    public static void globalSetup() {
        // Inicializa a configuração base do Rest Assured
        ApiConfig.getInstance();
        System.out.println("✅ Rest Assured configuration initialized.");
    }

    @Before
    public void beforeEachScenario() {
        // Aqui você pode limpar ou redefinir dados antes de cada cenário
        RestAssured.reset();
        ApiConfig.getInstance(); // reconfigura base URI e headers
        System.out.println("🔄 Scenario setup complete.");
    }

    @After
    public void afterEachScenario() {
        // Aqui você pode limpar tokens, cache, etc.
        System.out.println("🧹 Scenario teardown complete.");
    }
}
