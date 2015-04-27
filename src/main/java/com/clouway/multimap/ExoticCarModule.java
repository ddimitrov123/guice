package com.clouway.multimap;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class ExoticCarModule extends AbstractModule {
  @Override
  protected void configure() {
    MapBinder<String, Car> mapBinder = MapBinder.newMapBinder(binder(), String.class, Car.class);
    mapBinder.addBinding("lambo").to(Lamborghini.class);
  }
}
