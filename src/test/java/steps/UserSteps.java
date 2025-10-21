package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import requestJson.CriarUsuario;
import services.UserService;
import utils.SharedInstance;

public class UserSteps {

    private UserService userService = new UserService();
    private CriarUsuario criarUsuario;

    @Given("que eu crio os dados de um usuario")
    public void criarUserSemAtivarEmail() {
        criarUsuario = new CriarUsuario();
    }

    @Given("que eu crio os dados de um usuario com o email {string} invalido")
    public void que_eu_crio_os_dados_de_um_usuario_com_o_email_invalido(String email) {
        criarUsuario = new CriarUsuario();
        criarUsuario.email = "null".equals(email) ? null : email;
    }

    @When("chamo a api de criação de usuario")
    public void criarUsuario() {
        userService.createUser(criarUsuario);
    }
}
