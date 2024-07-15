package com.jsonplaceholder.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class User {

  private Integer id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

}

@Data
class Address {

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;
}

@Data
class Geo {

  private String lat;
  private String lng;
}

@Data
class Company {

  private String name;
  private String catchPhrase;
  private String bs;
}
