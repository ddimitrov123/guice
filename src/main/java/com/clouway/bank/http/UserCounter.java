package com.clouway.bank.http;

import com.clouway.bank.db.SessionRepository;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@At("/home")
@Show("/home.html")
public class UserCounter {
  private SessionRepository sessionRepository;
  public String online;

  @Inject
  public UserCounter(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  @Get
  public void get(){
    online = String.valueOf(sessionRepository.getAllCookies().size());
  }

}
