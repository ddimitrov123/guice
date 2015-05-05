package com.clouway.bank;

import com.clouway.bank.filters.ConnectionFilter;
import com.clouway.bank.filters.SecurityFilter;
import com.clouway.bank.http.History;
import com.clouway.bank.http.LogOut;
import com.clouway.bank.http.Login;
import com.clouway.bank.http.Registration;
import com.clouway.bank.http.UserCounter;
import com.clouway.bank.http.Welcome;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.sitebricks.SitebricksModule;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class AppConfig extends GuiceServletContextListener {
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new ServletModule() {
      @Override
      protected void configureServlets() {
        filter("/*").through(ConnectionFilter.class);
        filter("/welcome").through(SecurityFilter.class);
      }
    }, new SitebricksModule() {
      @Override
      protected void configureSitebricks() {
        at("/registration").show(Registration.class);
        at("/login").show(Login.class);
        at("/welcome").show(Welcome.class);
        at("/logout").show(LogOut.class);
        at("/home").show(UserCounter.class);
        at("/history").show(History.class);
      }
    }, new Module());
  }
}
