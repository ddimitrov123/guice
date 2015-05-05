package com.clouway.bank.db;

import java.util.List;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface SessionRepository {
  void registerCookie(String username, String value, long date);
  boolean refreshCookie(String name);
  Session getSession(String value);
  void deleteCookie(String name);
  List<Session> getAllCookies();
}
