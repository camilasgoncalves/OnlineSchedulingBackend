package services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApiConfig;
import utils.SharedInstance;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected final RequestSpecification requestSpec;

    public BaseService() {
        this.requestSpec = ApiConfig.getInstance().getRequestSpecification();
    }

    // ==============================
    // 🔹 Métodos GET
    // ==============================

    public void doGet(String endpoint) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    public void doGetWithParams(String endpoint, Map<String, Object> params) {
        Response response = given()
                .spec(requestSpec)
                .queryParams(params)
                .when()
                .get(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    // ==============================
    // 🔹 Métodos POST
    // ==============================

    public void doPostWithBody(String endpoint, Object body) {
        Response response = given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    public void doPostWithBodyAndHeaders(String endpoint, Object body, Map<String, String> headers) {
        Response response = given()
                .spec(requestSpec)
                .headers(headers)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    public void doPostWithBodyAndParams(String endpoint, Object body, Map<String, Object> params) {
        Response response = given()
                .spec(requestSpec)
                .queryParams(params)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    // ==============================
    // 🔹 Métodos PUT
    // ==============================

    public void doPut(String endpoint, Object body) {
        Response response = given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    public void doPutWithHeaders(String endpoint, Object body, Map<String, String> headers) {
        Response response = given()
                .spec(requestSpec)
                .headers(headers)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    // ==============================
    // 🔹 Métodos DELETE
    // ==============================

    public void doDelete(String endpoint) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }

    public void doDeleteWithParams(String endpoint, Map<String, Object> params) {
        Response response = given()
                .spec(requestSpec)
                .queryParams(params)
                .when()
                .delete(endpoint)
                .then()
                .extract().response();

        SharedInstance.getInstance().setResponse(response);
    }
}
