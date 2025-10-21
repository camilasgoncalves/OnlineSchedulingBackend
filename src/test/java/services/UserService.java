package services;

import requestJson.CriarUsuario;
import utils.SharedInstance;

public class UserService extends BaseService {

    private String userCreateEndpoint = "/user/register";
    private String userGetEndpoint = "/user/info";
    private String userDeleteEndpoint = "/user/delete";
    private String userUpdatePasswordEndpoint = "/user/updatePassword";
    private String userEmailActivationEndpoint = "/user/email_activation";

    public void createUser(CriarUsuario criarUsuario) {
        this.doPostWithBody(userCreateEndpoint, criarUsuario.toJson());
    }
}
