package com.jsonplaceholder.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Users extends BaseAPI {

  public static final String USERS = "/users";

  public Response getUsers() {
    Response response = given()
        .spec(getSpecBuilder())
        .when()
        .get(USERS);
    response.prettyPrint();
    return response;
  }
}
