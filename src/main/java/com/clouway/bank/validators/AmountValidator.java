package com.clouway.bank.validators;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class AmountValidator implements NumberValidator {
  @Override
  public boolean isValid(String expressionOne, String expressionTwo) {
    boolean deposit = expressionOne.matches("^[0-9]{1,10}([.|,][0-9]{1,2})?$");
    boolean withdraw = expressionTwo.matches("^[0-9]{1,10}([.|,][0-9]{1,2})?$");
    return deposit || withdraw;
  }
}
