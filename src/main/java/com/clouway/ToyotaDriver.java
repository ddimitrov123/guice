package com.clouway;

import com.google.inject.Inject;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class ToyotaDriver {
  private Car car;

  @Inject
  public ToyotaDriver(Car car) {
    this.car = car;
  }

  public void driveToyotaCar(){
    car.fillGasoline();
    car.move();
  }
}
