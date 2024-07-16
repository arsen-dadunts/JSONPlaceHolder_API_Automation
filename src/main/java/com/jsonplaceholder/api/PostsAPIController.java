package com.jsonplaceholder.api;

import static com.jsonplaceholder.common.Constants.CREATED;
import static com.jsonplaceholder.common.Constants.OK;
import static io.restassured.RestAssured.given;

import com.jsonplaceholder.pojo.Post;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostsAPIController extends BaseAPI {

  public static final String POSTS = "/posts";

  public Post[] getPostsByUserId(int userId) {
    log.info("Get posts by '{}' userId", userId);
    Response response = given()
        .spec(getSpecBuilder())
        .queryParam("userId", userId)
        .when()
        .get(POSTS);
    response.prettyPrint();
    return response.then().statusCode(OK).extract().body().as(Post[].class);
  }

  public Post createPost(Post postPayload) {
    log.info("Create a new post");
    Response response = given()
        .spec(getSpecBuilder())
        .body(postPayload)
        .when()
        .post(POSTS);
    response.prettyPrint();
        return response.then().statusCode(CREATED).extract().body().as(Post.class);
  }
}
