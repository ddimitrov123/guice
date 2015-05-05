package com.clouway.bank.db;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class User {
  public final String name;
  public final String password;
  public final Double balance;

  public User(String name, String password, Double balance) {
    this.name = name;
    this.password = password;
    this.balance = balance;
  }
}
