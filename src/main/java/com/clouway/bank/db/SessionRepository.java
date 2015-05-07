package com.clouway.bank.db;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface SessionRepository {
  void registerSession(String username, String value, long date);
  boolean refreshSession(String name);
  Session getSession(String value);
  void deleteSession(String name);
  int getActiveSessions();
}
