package com.clouway.bank;

import com.clouway.bank.db.*;
import com.clouway.bank.validators.AmountValidator;
import com.clouway.bank.validators.NumberValidator;
import com.clouway.bank.validators.UserRegExValidator;
import com.clouway.bank.validators.UserValidator;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Module extends AbstractModule {
  @Override
  protected void configure() {
    bind(UserValidator.class).to(UserRegExValidator.class);
    bind(UserRepository.class).to(PersistenceUserRepository.class);
    bind(SessionRepository.class).to(PersistenceSessionRepository.class);
    bind(NumberValidator.class).to(AmountValidator.class);
    bind(HistoryRepository.class).to(PersistentHistoryRepository.class);
  }

  @Provides
  @RequestScoped
  Connection connection(){
    try {
      return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "123456");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
