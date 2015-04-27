package com.clouway.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new CarModule());
    Driver driver = injector.getInstance(Driver.class);
    driver.drive();
  }
}
