package com.jsonplaceholder.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.apache.commons.lang3.Range;

public class Helpers {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static Object getRandomObjectFromList(List<Object> list) {
    return list.get(new Random().nextInt(list.size() - 1));
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
