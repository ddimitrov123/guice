package com.clouway;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Main {
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new CarModule());
        injector.getInstance(Car.class);
        Person person = injector.getInstance(Person.class);
        ToyotaDriver toyotaDriver = injector.getInstance(ToyotaDriver.class);
        person.driveOpelCar();
        System.out.println("-------------------------");
        toyotaDriver.driveToyotaCar();
    }
}
