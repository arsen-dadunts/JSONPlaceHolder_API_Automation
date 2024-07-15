package com.jsonplaceholder.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class Post {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;

}
