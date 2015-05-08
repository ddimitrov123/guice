package com.clouway.bank.validators;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface UserValidator {
  boolean isValid(String username, String password);
}
