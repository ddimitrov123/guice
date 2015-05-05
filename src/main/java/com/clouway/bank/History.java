package com.clouway.bank;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class History {
  public String transaction;
  public String before_transaction;
  public String after_transaction;
  public String date;
  public String name;

  public History(String transaction, String before_transaction, String after_transaction, String date, String name) {
    this.transaction = transaction;
    this.before_transaction = before_transaction;
    this.after_transaction = after_transaction;
    this.date = date;
    this.name = name;
  }
}
