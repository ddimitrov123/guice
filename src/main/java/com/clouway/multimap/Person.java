package com.clouway.multimap;

import com.google.inject.Inject;

import java.util.Map;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Person {
  private Map<String, Car> cars;

  @Inject
  public Person(Map<String, Car> cars) {
    this.cars = cars;
  }

  public Map<String, Car> getCars() {
    return cars;
  }

  public void drive(String carName){
    if(cars.containsKey(carName)){
      cars.get(carName).refillGasoline();
      cars.get(carName).move();
    }
  }
  public void driveAllCars(){
    for (Map.Entry<String, Car> each : cars.entrySet()){
      each.getValue().move();
    }
  }

}