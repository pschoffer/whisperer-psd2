package com.techsylvania.klarnauts.whisperer.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

  @Id private String id;
  private String iban;

  @Column(name = "user_id")
  private String userId;

  private String prefix;

  @Column(name = "bank_code")
  private String bankCode;

  private String bic;
  private String currency;
  private String country;

  public Account(
      String id,
      String iban,
      String userId,
      String prefix,
      String bankCode,
      String bic,
      String currency,
      String country) {
    this.id = id;
    this.iban = iban;
    this.userId = userId;
    this.prefix = prefix;
    this.bankCode = bankCode;
    this.bic = bic;
    this.currency = currency;
    this.country = country;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
