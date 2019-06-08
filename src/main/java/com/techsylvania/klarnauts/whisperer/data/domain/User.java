package com.techsylvania.klarnauts.whisperer.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id @GeneratedValue private Long id;
  private String email;
  private String password;

  @Column(name = "birth_date")
  private String birthDate;

  private String gender;

  @Column(name = "zip_code")
  private String zipCode;

  private String city;
  private String country;

  public User() {}

  public User(
      Long id,
      String email,
      String password,
      String birthDate,
      String gender,
      String zipCode,
      String city,
      String country) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.birthDate = birthDate;
    this.gender = gender;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
