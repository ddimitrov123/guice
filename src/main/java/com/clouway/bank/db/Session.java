package com.clouway.bank.db;

import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class Session {
  public String username;
  public String sessionId;
  public long expdate;

  public Session(String username, String sessionId, long expdate) {
    this.username = username;
    this.sessionId = sessionId;
    this.expdate = expdate;
  }
}
