package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import services.UserService;
import utils.SharedInstance;

public class UserSteps {

    private UserService userService = new UserService();

    @Given("que eu crio os dados de um usuario")
    public void criarUserSemAtivarEmail() {
        SharedInstance.getInstance().createNewUsuario();
    }

    @When("chamo a api de criação de usuario")
    public void criarUsuario() {
        userService.createUser();
    }
}
