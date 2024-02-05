package com.example.common.entity;


import jakarta.persistence.*;

@Entity
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "custId", nullable = false)
  private Long id;

  @Column(name = "username")
  private String userName;
  @Column(name = "password")
  private String password;
  @Column(name = "name")
  private String name;
  @Column(name = "surname")
  private String surName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }
}
