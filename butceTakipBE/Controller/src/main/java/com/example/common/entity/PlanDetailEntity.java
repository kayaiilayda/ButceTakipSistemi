package com.example.common.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PlanDetailEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  private Long custId;
  private String paymentType;
  private String paymentPlace;
  private String paymentDesc;
  private Date date;
  private Double price;

  public Long getCustId() {
    return custId;
  }

  public void setCustId(Long custId) {
    this.custId = custId;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public String getPaymentPlace() {
    return paymentPlace;
  }

  public void setPaymentPlace(String paymentPlace) {
    this.paymentPlace = paymentPlace;
  }

  public String getPaymentDesc() {
    return paymentDesc;
  }

  public void setPaymentDesc(String paymentDesc) {
    this.paymentDesc = paymentDesc;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
