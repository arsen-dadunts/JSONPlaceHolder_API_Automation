package com.jsonplaceholder.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.json.JSONObject;

public class Posts extends BaseAPI {

  public static final String POSTS = "/posts";

  public Response getPostsByUserId(String userId) {
    Response response = given()
        .spec(getSpecBuilder())
        .queryParam("userId", userId)
        .when()
        .get(POSTS);
    response.prettyPrint();
    return response;
  }

  public Response createPost(String userId, String title, String body) {
   JSONObject payload = new JSONObject();
    payload.put("userId", userId);
    payload.put("title", title);
    payload.put("body", body);
    Response response = given()
        .spec(getSpecBuilder())
        .body(payload.toString())
        .when()
        .post(POSTS);
    response.prettyPrint();
    return response;
  }
}
