package com.clouway.multimap;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Map;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ExoticCarModule(), new CarModule());
    Person person = injector.getInstance(Person.class);
    Map<String, Car> cars = person.getCars();
//    person.move("lambo");
    person.driveAllCars();
  }
}
