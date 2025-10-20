package com.onlinescheduling.api.services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class User {

    public void createUser() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"camila@example.com\",\"password\":\"Senha@123\",\"birthday\":\"1999-05-25\", \"name\":\"Camila Gonçalves\", \"provider\":\"true\", \"speciality\":\"Tester\"}")
                .when()
                .post("/user/register");
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        response.then()
                .statusCode(201)
                .body("message", equalTo("Usuário registrado."));
    }
}
