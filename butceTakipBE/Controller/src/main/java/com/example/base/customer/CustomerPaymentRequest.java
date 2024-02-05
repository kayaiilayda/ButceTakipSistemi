package com.example.base.customer;

import java.util.Date;

public class CustomerPaymentRequest {

  String custId;
  String paymentType;
  String paymentPlace;
  String paymentDesc;
  Date date;
  Double price;

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
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
