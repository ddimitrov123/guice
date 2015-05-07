package com.clouway.bank.validators;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class AmountValidator implements NumberValidator {
  @Override
  public boolean isValid(String expressionOne, String expressionTwo) {
    return expressionOne.matches("^[0-9]{1,10}([.|,][0-9]{1,2})?$") || expressionTwo.matches("^[0-9]{1,10}([.|,][0-9]{1,2})?$");
  }
}
