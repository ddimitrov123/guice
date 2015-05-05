package com.clouway.bank.db;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface UserRepository {
  boolean registerUser(String username, String password, Double balance);
  User findUser(String username, String password);
  void updateBalance(String name, Double newBalance);
  Double findBalance(String username);
}
