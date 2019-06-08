package com.techsylvania.klarnauts.whisperer.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CustomerPurchaseCountAndAmountSum {

  Integer userId;
  BigInteger userCount;
  BigDecimal totalAmount;

  public CustomerPurchaseCountAndAmountSum(
      Integer userId, BigInteger userCount, BigDecimal totalAmount) {
    this.userId = userId;
    this.userCount = userCount;
    this.totalAmount = totalAmount;
  }

  public CustomerPurchaseCountAndAmountSum(Object[] props) {
    this.userId = (Integer) props[0];
    this.userCount = (BigInteger) props[1];
    this.totalAmount = (BigDecimal) props[2];
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BigInteger getUserCount() {
    return userCount;
  }

  public void setUserCount(BigInteger userCount) {
    this.userCount = userCount;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}
