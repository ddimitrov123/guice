package com.clouway;

import com.google.inject.Inject;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Toyota implements Car {
//  private Engine engine;

//  @Inject
//  public Toyota(Engine engine) {
//    this.engine = engine;
//  }

  public void move() {
//    engine.type();
    System.out.println("Drive Toyota");
  }

  public void fillGasoline() {
    System.out.println("Fill gasoline to Toyota");
  }
}
