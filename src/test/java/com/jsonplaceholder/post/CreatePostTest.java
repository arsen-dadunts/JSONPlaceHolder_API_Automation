package com.jsonplaceholder.post;

import static com.jsonplaceholder.utils.LogManager.log;
import static com.jsonplaceholder.utils.Helpers.generateRandomString;
import static com.jsonplaceholder.utils.Helpers.getRandomObjectFromList;
import static com.jsonplaceholder.utils.Helpers.isNumberInRange;

import com.jsonplaceholder.api.PostsAPIController;
import com.jsonplaceholder.api.UsersAPIController;
import com.jsonplaceholder.pojo.Post;
import com.jsonplaceholder.pojo.User;
import java.util.List;
import org.apache.commons.lang3.Range;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CreatePostTest {

  private PostsAPIController posts;
  private User user;

  @Test(description = "Get a random user (userID) and print out their email address to the console.")
  public void getRandomUserFromUsers() {
    UsersAPIController usersApi = new UsersAPIController();
    User[] users = usersApi.getUsers();
    user = (User) getRandomObjectFromList(List.of(users));
    log.info("Random user email: {}", user.getEmail());
  }

  @Test(description = "Using this userID, get the user’s associated posts and verify they contain "
      + "valid Post IDs (an integer between 1 and 100).", priority = 1)
  public void getPostsAndVerifyIDsAreValid() {
    posts = new PostsAPIController();
    Range<Integer> validIdsRange = Range.between(1, 100);
    Post[] userPosts = posts.getPostsByUserId(user.getId());
    Assertions.assertThat(userPosts)
        .as("Post IDs (an integer between 1 and 100).")
        .allMatch(post -> isNumberInRange(post.getId(), validIdsRange));
  }

  @Test(description = "Create a post using the same userID with a non-empty title and body, and "
      + "verify the correct response is returned.", priority = 2)
  public void createPostAndVerifyResponse() {
    Post expectedPost = new Post();
    expectedPost.setUserId(user.getId());
    expectedPost.setBody(generateRandomString(5));
    expectedPost.setTitle(generateRandomString(10));
    Post createdPost = posts.createPost(expectedPost);
    Assertions.assertThat(createdPost)
        .as("Created post")
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(expectedPost);
  }
}
