package com.clouway.singletonandeagersingleton;

import com.google.inject.AbstractModule;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class CarModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(Car.class).to(Toyota.class);
  }
}
