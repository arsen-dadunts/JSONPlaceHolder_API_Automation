package post;

import static com.jsonplaceholder.api.BaseAPI.log;
import static com.jsonplaceholder.common.Constants.CREATED;
import static com.jsonplaceholder.common.Constants.OK;
import static com.jsonplaceholder.utils.Helpers.generateRandomString;
import static com.jsonplaceholder.utils.Helpers.getRandomObjectFromResponse;
import static com.jsonplaceholder.utils.Helpers.isNumberInRange;
import static org.hamcrest.Matchers.equalTo;

import com.jsonplaceholder.api.Posts;
import com.jsonplaceholder.api.Users;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.commons.lang3.Range;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePostTest {

  private static final String POST_ID_MESSAGE = "'%s' id is not in valid range";

  private Posts posts;
  private String userId;

  @Test(description = "Get a random user (userID) and print out their email address to the console.")
  public void getRandomUserFromUsers() {
    Users users = new Users();
    Response usersResponse = users.getUsers();
    usersResponse.then().statusCode(OK);
    JSONObject user = getRandomObjectFromResponse(usersResponse);
    userId = String.valueOf(user.get("id"));
    log.info("Random user email: {}", user.get("email"));
  }

  @Test(description = "Using this userID, get the user’s associated posts and verify they contain "
      + "valid Post IDs (an integer between 1 and 100).", priority = 1)
  public void getPostsAndVerifyIDsAreValid() {
    posts = new Posts();
    Range<Integer> validIdsRange = Range.between(1, 100);
    Response postsResponse = posts.getPostsByUserId(userId);
    postsResponse.then().statusCode(OK);
    postsResponse.jsonPath().getList("id")
        .forEach(id -> Assert.assertTrue(isNumberInRange((Integer) id, validIdsRange),
            String.format(POST_ID_MESSAGE, id)));
  }

  @Test(description = "Create a post using the same userID with a non-empty title and body, and "
      + "verify the correct response is returned.", priority = 2)
  public void createPostAndVerifyResponse() {
    Response createPostResponse = posts.createPost(userId, generateRandomString(5),
        generateRandomString(10));
    createPostResponse.then().statusCode(CREATED)
        .body(
            JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemas/createPostResponse.json"))
        .body("userId", equalTo(userId));
  }
}
