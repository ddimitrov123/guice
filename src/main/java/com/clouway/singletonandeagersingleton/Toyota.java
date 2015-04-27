package com.clouway.singletonandeagersingleton;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Toyota implements Car {
  public void refillGasoline() {
    System.out.println("Refill gasoline to Toyota");
  }

  public void move() {
    System.out.println("Moving with Toyota");
  }
}
