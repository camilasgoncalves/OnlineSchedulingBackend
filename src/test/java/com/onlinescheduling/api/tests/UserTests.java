package com.onlinescheduling.api.tests;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.onlinescheduling.api.services.User;



public class UserTests {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://onlineschedulingback.up.railway.app";
    }

    @Test
    public void createUser(){
        User userService = new User();
        userService.createUser();
    }

}