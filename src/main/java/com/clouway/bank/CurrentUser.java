package com.clouway.bank;

import com.clouway.bank.db.Session;
import com.clouway.bank.db.SessionRepository;
import com.clouway.bank.db.User;
import com.clouway.bank.db.UserRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class CurrentUser {
  private Provider<HttpServletRequest> requestProvider;
  private SessionRepository sessionRepository;
  private UserRepository userRepository;

  @Inject
  public CurrentUser(Provider<HttpServletRequest> requestProvider, SessionRepository sessionRepository, UserRepository userRepository){

    this.requestProvider = requestProvider;
    this.sessionRepository = sessionRepository;
    this.userRepository = userRepository;
  }

  public String getUsername() {
    return sessionRepository.getSession(getSid()).username;
  }

  public String getSessionId() {
    return sessionRepository.getSession(getSid()).sessionId;
  }

  public long getExpdate() {
    return sessionRepository.getSession(getSid()).expdate;
  }

  public Double findBalance(){
    return userRepository.findBalance(getUsername());
  }
  public void updateBalance(Double newBalance){
    userRepository.updateBalance(getUsername(), newBalance);
  }

  public User findUser(String username, String password){
    return userRepository.findUser(username, password);
  }

  public Session getSession(){
    return sessionRepository.getSession(getSid());
  }

  public void registerCookie(String username, String sid){
    sessionRepository.registerCookie(username, sid, new Date().getTime());
  }

  public void refreshCookie(String username){
    sessionRepository.refreshCookie(username);
  }

  public String getSid(){
    String sid = null;
    Cookie[] cookies = requestProvider.get().getCookies();
    if (cookies == null) {
      return null;
    }

    for (Cookie each : cookies) {
      if (each.getName().equalsIgnoreCase("sid")) {
        sid = each.getValue();
      }
    }
    return sid;
  }

}
