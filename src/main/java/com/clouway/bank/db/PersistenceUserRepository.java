package com.clouway.bank.db;

import com.google.inject.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class PersistenceUserRepository implements UserRepository {
  private final DataStore dataStore;

  @Inject
  public PersistenceUserRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  @Override
  public boolean registerUser(String username, String password, Double balance) {
    return dataStore.execute("INSERT INTO users(name, password, balance) VALUES('" + username + "', '" + password + "', '" + balance + "')");
  }

  @Override
  public User findUser(String username, String password){
    return dataStore.fetchRow("SELECT name, password, balance FROM users WHERE name = '" + username + "'" + "AND password = '" + password + "'", new RowFetcher<User>() {
      @Override
      public User fetchRow(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String password = rs.getString("password");
        Double balance = rs.getDouble("balance");
        return new User(name, password, balance);
      }
    });
  }

  @Override
  public void updateBalance(String name, Double newBalance) {
    dataStore.execute("UPDATE users SET balance = '" + newBalance + "' WHERE name = '" + name + "'");
  }

  @Override
  public Double findBalance(String username) {
    return dataStore.fetchRow("select balance from users where name = '" + username + "'", new RowFetcher<Double>() {
      @Override
      public Double fetchRow(ResultSet rs) throws SQLException {
        return rs.getDouble("balance");
      }
    });
  }
}
