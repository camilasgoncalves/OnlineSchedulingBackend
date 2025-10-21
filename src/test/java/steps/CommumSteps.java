package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.SharedInstance;

import java.util.Arrays;

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

        String[] mensagensPossiveis = mensagemErro.split("\\|\\|");

        boolean encontrouMensagem = Arrays.stream(mensagensPossiveis)
                .map(String::trim)
                .anyMatch(responseBody::contains);

        Assertions.assertTrue(
                encontrouMensagem,
                "Nenhuma das mensagens esperadas foi encontrada no body.\n" +
                        "Esperado conter uma de: " + Arrays.toString(mensagensPossiveis) +
                        "\nBody completo:\n" + responseBody
        );
    }
}
