package com.clouway;

import com.google.inject.Inject;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */

public class Person {
  private Car car;

  @Inject
  public Person(@OpelAnnotation Car car) {
    this.car = car;
  }

  public void driveOpelCar(){
    car.fillGasoline();
    car.move();
  }
}
