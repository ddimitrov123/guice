package com.clouway.singletonandeagersingleton;

import com.google.inject.AbstractModule;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class PersonModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Person.class).to(John.class).asEagerSingleton();
  }
}
