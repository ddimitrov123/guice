package com.clouway.bank;

import com.clouway.bank.db.*;
import com.clouway.bank.validators.AmountValidator;
import com.clouway.bank.validators.NumberValidator;
import com.clouway.bank.validators.RegExValidator;
import com.clouway.bank.validators.UserValidator;
import com.google.inject.AbstractModule;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Module extends AbstractModule {
  @Override
  protected void configure() {
    bind(ConProvider.class).to(ConnectionConProvider.class);
    bind(UserValidator.class).to(RegExValidator.class);
    bind(UserRepository.class).to(PersistenceUserRepository.class);
    bind(SessionRepository.class).to(PersistenceSessionRepository.class);
    bind(NumberValidator.class).to(AmountValidator.class);
    bind(HistoryRepository.class).to(PersistentHistoryRepository.class);
  }
}
