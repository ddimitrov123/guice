package com.clouway.aop;

import com.google.inject.Inject;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Driver {
  private Car car;

  @Inject
  public Driver(Car car) {
    this.car = car;
  }

  @FillGasoline
  public void drive() {
    car.move();
  }
}
