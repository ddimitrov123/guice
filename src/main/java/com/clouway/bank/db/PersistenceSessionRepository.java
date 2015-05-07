package com.clouway.bank.db;

import com.google.inject.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class PersistenceSessionRepository implements SessionRepository {
  private DataStore dataStore;

  @Inject
  public PersistenceSessionRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  @Override
  public void registerSession(String username, String value, long date) {
    dataStore.execute("INSERT INTO cookies(name, value, expdate) VALUES('" + username + "', '" + value + "', '" + date + "')");
  }

  @Override
  public boolean refreshSession(String name) {
    return dataStore.execute("update cookies set expdate = " + new Date().getTime() + " where name = '" + name + "'");
  }

  @Override
  public Session getSession(String value) {
    return dataStore.fetchRow("SELECT * FROM cookies WHERE value = '" + value + "'", new RowFetcher<Session>() {
      @Override
      public Session fetchRow(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String value = rs.getString("value");
        long expDate = rs.getLong("expdate");
        return new Session(name, value, expDate);
      }
    });
  }

  @Override
  public void deleteSession(String name) {
    dataStore.execute("DELETE FROM cookies WHERE name = '" + name + "'");
  }

  @Override
  public int getActiveSessions() {
    return dataStore.getNumberOfRows();
  }
}
