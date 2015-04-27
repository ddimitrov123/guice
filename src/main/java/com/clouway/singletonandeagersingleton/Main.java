package com.clouway.singletonandeagersingleton;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new PersonModule(), new CarModule());
    Driver driver = injector.getInstance(Driver.class);
    Driver driver1 = injector.getInstance(Driver.class);
    System.out.println(driver);
    System.out.println(driver1);
    driver.drive();
    driver.drive();
    driver1.drive();
    driver1.drive();
  }
}
