package com.clouway.bank;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class History {
  public String transaction;
  public String beforeTransaction;
  public String afterTransaction;
  public String date;
  public String name;

  public History(String transaction, String beforeTransaction, String afterTransaction, String date, String name) {
    this.transaction = transaction;
    this.beforeTransaction = beforeTransaction;
    this.afterTransaction = afterTransaction;
    this.date = date;
    this.name = name;
  }
}
