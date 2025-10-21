package utils;

import io.restassured.response.Response;
import requestJson.CriarUsuario;

/**
 * Singleton que compartilha dados entre diferentes Steps.
 * Pode armazenar o último Response da API e um usuário (CriarUsuario)
 * criado durante o cenário.
 */
public class SharedInstance {

    private static SharedInstance instance;
    private Response response;

    // Construtor privado para padrão Singleton
    private SharedInstance() {
    }

    // Obtém a instância única
    public static synchronized SharedInstance getInstance() {
        if (instance == null) {
            instance = new SharedInstance();
        }
        return instance;
    }

    // ===============================
    // Métodos relacionados ao Response
    // ===============================

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }

    // ===============================
    // Métodos utilitários
    // ===============================

    public void clear() {
        this.response = null;
    }
}
