package com.juaracoding;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class TestGetMovieDbNowPlaying {

    @Test
    public void testApiNowPlaying() {
        given()
                .queryParam("api_key", "866cef0fbb855bac62e84ebcbbd4b18e")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then()
                .statusCode(200);
    }
    @Test public void testGetNowPlaying(){
        Response response = given()
                .queryParam("api_key", "866cef0fbb855bac62e84ebcbbd4b18e")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing");
        response.then()
                .statusCode(200);
        String responseBody = response.getBody().asString();
    System.out.println(responseBody);
    }
}
