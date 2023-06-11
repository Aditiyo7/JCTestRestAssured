package com.juaracoding;

import io.restassured.response.Response;
import  org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetMovieDbPopular {
    @Test
    public void testApiPopular() {
        given()
                .queryParam("api_key", "866cef0fbb855bac62e84ebcbbd4b18e")
                .when()
                .get("https://api.themoviedb.org/3/movie/popular")
                .then()
                .statusCode(200);
    }
    @Test
    public void testGetPopular(){
        Response response = given()
                .queryParam("api_key", "866cef0fbb855bac62e84ebcbbd4b18e")
                .when()
                .get("https://api.themoviedb.org/3/movie/popular");
        response.then()
                .statusCode(200);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
