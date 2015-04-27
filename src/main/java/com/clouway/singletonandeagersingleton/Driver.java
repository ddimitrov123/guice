package com.clouway.singletonandeagersingleton;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@Singleton
public class Driver {
  private int counter = 0;
  private Car car;

  @Inject
  public Driver(Car car) {
    this.car = car;
  }

  public void drive(){
    car.refillGasoline();
    car.move();
    counter++;
    System.out.println(counter);
  }
}
