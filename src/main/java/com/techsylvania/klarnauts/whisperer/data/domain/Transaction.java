package com.techsylvania.klarnauts.whisperer.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

  @Id private String id;

  @Column(name = "account_id")
  private String accountId;

  private String amount;
  private String currency;

  @Column(name = "merchant_id")
  private String merchantId;

  @Column(name = "bookkeeping_date")
  private String bookkeepingDate;

  @Column(name = "mcc_code")
  private String mccCode;

  @Column(name = "credit_debit_indicator")
  private String creditDebitIndicator;

  @Column(name = "installment_indicator")
  private String installmentIndicator;

  @Column(name = "zip_code")
  private String zipCode;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getBookkeepingDate() {
    return bookkeepingDate;
  }

  public void setBookkeepingDate(String bookkeepingDate) {
    this.bookkeepingDate = bookkeepingDate;
  }

  public String getMccCode() {
    return mccCode;
  }

  public void setMccCode(String mccCode) {
    this.mccCode = mccCode;
  }

  public String getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(String creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public String getInstallmentIndicator() {
    return installmentIndicator;
  }

  public void setInstallmentIndicator(String installmentIndicator) {
    this.installmentIndicator = installmentIndicator;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Transaction(
      String id,
      String accountId,
      String amount,
      String currency,
      String merchantId,
      String bookkeepingDate,
      String mccCode,
      String creditDebitIndicator,
      String installmentIndicator,
      String zipCode) {
    this.id = id;
    this.accountId = accountId;
    this.amount = amount;
    this.currency = currency;
    this.merchantId = merchantId;
    this.bookkeepingDate = bookkeepingDate;
    this.mccCode = mccCode;
    this.creditDebitIndicator = creditDebitIndicator;
    this.installmentIndicator = installmentIndicator;
    this.zipCode = zipCode;
  }
}
