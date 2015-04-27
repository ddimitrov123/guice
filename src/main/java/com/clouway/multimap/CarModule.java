package com.clouway.multimap;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class CarModule extends AbstractModule {
  @Override
  protected void configure() {
    MapBinder<String, Car> mapBinder = MapBinder.newMapBinder(binder(), String.class, Car.class);
    mapBinder.addBinding("toyota").to(Toyota.class);
    mapBinder.addBinding("opel").to(Opel.class);
  }
}
