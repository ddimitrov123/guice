package com.clouway.bank.validators;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class UserRegExValidator implements UserValidator {
  public boolean isValid(String username, String password) {
    return username.matches("^[a-zA-Z0-9]{3,10}$") && password.matches("^[a-zA-Z0-9]{6,12}$");
  }
}
