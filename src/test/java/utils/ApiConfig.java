package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {

    private static ApiConfig instance;
    private final RequestSpecification requestSpecification;

    private ApiConfig() {
        // Configuração padrão global do Rest Assured
        RestAssured.baseURI = "https://onlineschedulingback.up.railway.app"; // altere conforme o ambiente

        this.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setRelaxedHTTPSValidation() // ignora problemas de certificado SSL
                .addHeader("Content-Type", "application/json")
                //.log(LogDetail.ALL) // loga tudo (útil pra debug)
                .build();

        // Define como padrão global
        RestAssured.requestSpecification = this.requestSpecification;
    }

    public static synchronized ApiConfig getInstance() {
        if (instance == null) {
            instance = new ApiConfig();
        }
        return instance;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
