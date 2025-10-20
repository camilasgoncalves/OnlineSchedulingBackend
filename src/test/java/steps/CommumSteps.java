package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.SharedInstance;

public class CommumSteps {

    @Then("deve retornar status code {int}")
    public void errorCode(int statusCode) {
        int actual = SharedInstance.getInstance().getResponse().getStatusCode();
        Assertions.assertEquals(statusCode, actual,
                "Status code diferente! Esperado: " + statusCode + " | Recebido: " + actual);
    }

    @And("deve retornar a mensagem {string}")
    public void errorMessage(String mensagemErro) {
        String responseBody = SharedInstance.getInstance().getResponse().getBody().asString();

        Assertions.assertTrue(
                responseBody.contains(mensagemErro),
                "Mensagem esperada não encontrada no body.\nEsperado conter: \""
                        + mensagemErro + "\"\nBody completo:\n" + responseBody
        );
    }
}
