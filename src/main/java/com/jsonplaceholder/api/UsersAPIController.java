package com.jsonplaceholder.api;

import static com.jsonplaceholder.common.Constants.OK;
import static io.restassured.RestAssured.given;

import com.jsonplaceholder.pojo.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersAPIController extends BaseAPI {

  public static final String USERS = "/users";

  public User[] getUsers() {
    log.info("Get users");
    Response response = given()
        .spec(getSpecBuilder())
        .when()
        .get(USERS);
    response.prettyPrint();
    return response.then().statusCode(OK).extract().as(User[].class);
  }
}
