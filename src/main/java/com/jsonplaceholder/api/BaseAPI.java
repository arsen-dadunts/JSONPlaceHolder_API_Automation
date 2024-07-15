package com.jsonplaceholder.api;

import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

  protected static final String BASE_URL = System.getProperty("base.url");

  protected static RequestSpecification specBuilder;
  protected static RestAssuredConfig config = CurlRestAssuredConfigFactory.createConfig();

  protected static RequestSpecification getSpecBuilder() {
    specBuilder = new RequestSpecBuilder()
        .setConfig(config)
        .setBaseUri(BASE_URL)
        .setContentType(ContentType.JSON)
        .setUrlEncodingEnabled(false)
        .build();
    return specBuilder;
  }
}
