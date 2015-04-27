package com.clouway;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class CarModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Car.class).to(Toyota.class);
    bind(Car.class).annotatedWith(OpelAnnotation.class).to(Opel.class);
//    bind(Engine.class).to(DieselEngine.class);
  }

//  @Provides
//  Toyota provideToyota(Engine engine){
//    return new Toyota(engine);
//  }
}
