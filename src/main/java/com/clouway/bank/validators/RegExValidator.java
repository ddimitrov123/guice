package com.clouway.bank.validators;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class RegExValidator implements UserValidator {
  public boolean isValid(String expressionOne, String expressionTwo) {
    boolean validUsername = expressionOne.matches("^[a-zA-Z0-9]{3,10}$");
    boolean validPassword = expressionTwo.matches("^[a-zA-Z0-9]{6,12}$");
    return validUsername && validPassword;
  }
}
