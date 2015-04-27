package com.clouway.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class CarModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Car.class).to(Toyota.class);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(FillGasoline.class), new ShellGasolineStation());
  }
}
