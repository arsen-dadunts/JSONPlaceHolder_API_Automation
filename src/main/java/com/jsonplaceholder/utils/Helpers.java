package com.jsonplaceholder.utils;

import io.restassured.response.Response;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.apache.commons.lang3.Range;
import org.json.JSONObject;

public class Helpers {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static JSONObject getRandomObjectFromResponse(Response response) {
    List<LinkedHashMap> usersList = response.jsonPath().getList(".");
    return new JSONObject(usersList.get(new Random().nextInt(usersList.size() - 1)));
  }

  public static boolean isNumberInRange(int num, Range<Integer> range) {
    return range.contains(num);
  }

  public static String generateRandomString(int length) {
    StringBuilder builder = new StringBuilder();
    IntStream.range(0, length)
        .forEach(i -> builder.append(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
    return builder.toString();
  }
}
