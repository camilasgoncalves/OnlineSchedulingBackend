package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import requestJson.CriarUsuario;
import services.UserService;
import utils.SharedInstance;

public class UserSteps {

    private UserService userService = new UserService();
    private CriarUsuario criarUsuario;
    private static String emailCriado;

    @Given("que eu crio os dados de um usuario")
    public void criarUserSemAtivarEmail() {
        criarUsuario = new CriarUsuario();
        emailCriado = criarUsuario.email;
    }

    @Given("que eu crio os dados de um usuario com o email {string} invalido")
    public void que_eu_crio_os_dados_de_um_usuario_com_o_email_invalido(String email) {
        criarUsuario = new CriarUsuario();
        criarUsuario.email = "null".equals(email) ? null : email;
    }
    @Given("que eu crio os dados de um usuario com a senha {string} invalida")
    public void que_eu_crio_os_dados_de_um_usuario_com_a_senha_invalida(String senha) {
        criarUsuario = new CriarUsuario();
        criarUsuario.password = "null".equals(senha) ? null : senha;
    }

    @Given("que eu crio os dados de um usuario com a data de nascimento {string} invalida")
    public void que_eu_crio_os_dados_de_um_usuario_com_a_data_de_nascimento_invalida(String dataNascimento) {
        criarUsuario = new CriarUsuario();
        criarUsuario.birthday = "null".equals(dataNascimento) ? null : dataNascimento;
    }

    @Given("que eu crio os dados de um usuario com o nome {string} invalido")
    public void que_eu_crio_os_dados_de_um_usuario_com_o_nome_invalido(String nome) {
        criarUsuario = new CriarUsuario();
        criarUsuario.name = "null".equals(nome) ? null : nome;
    }

    @Given("que eu crio os dados de um usuario com provider {string} e specialty {string}")
    public void que_eu_crio_os_dados_de_um_usuario_com_provider_e_specialty(String provider, String specialty) {
        criarUsuario = new CriarUsuario();
        Boolean isProvider = null;
        if (!"null".equalsIgnoreCase(provider)) {
            isProvider = Boolean.parseBoolean(provider);}
        String specialtyValue = "null".equalsIgnoreCase(specialty) ? null : specialty;
        criarUsuario.provider = isProvider;
        criarUsuario.specialty = specialtyValue;
    }

    @Given("que eu crio os dados de um usuario com um e-mail já cadastrado")
    public void criarUserComEmailJaExistente() {
        criarUsuario = new CriarUsuario();
        criarUsuario.email = emailCriado;
    }

    @When("chamo a api de criação de usuario")
    public void criarUsuario() {
        userService.createUser(criarUsuario);
    }
}
