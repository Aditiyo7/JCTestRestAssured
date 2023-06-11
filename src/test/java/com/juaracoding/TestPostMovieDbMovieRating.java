package com.juaracoding;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPostMovieDbMovieRating {

    @Test
    public void testMovieRating(){
        float rating = 9.5f;
        JSONObject request = new JSONObject();
        request.put("value",rating);
        System.out.println(request.toJSONString());
        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NjZjZWYwZmJiODU1YmFjNjJlODRlYmNiYmQ0YjE4ZSIsInN1YiI6IjY0ODMxMWM1YmYzMWYyNTA1ZjNkY2FhNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XlVUob1knofb2Qjz5mt-ik6d1oQIOzO15fMVK5_em7s")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/569094/rating")
                .then()
                .statusCode(201)
                .log().all();
    }
}
