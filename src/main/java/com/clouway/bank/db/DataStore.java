package com.clouway.bank.db;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class DataStore {
  private Provider<Connection> connection;

  @Inject
  public DataStore(Provider<Connection> connection) {
    this.connection = connection;
  }

  public boolean execute(String query) {
    try {
      connection.get().createStatement().execute(query);
    } catch (SQLException e) {
      return false;
    }
    return true;
  }

  public <T> T fetchRow(String query, RowFetcher<T> fetcher) {
    T rowItem = null;
    try {
      Statement stmt = connection.get().createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        rowItem = fetcher.fetchRow(rs);
      }
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rowItem;
  }

  public <T> List<T> fetchRows(String query, RowFetcher<T> fetcher) {
    List<T> result = new ArrayList<T>();
    try {
      Statement stmt = connection.get().createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        T rowItem = fetcher.fetchRow(rs);
        result.add(rowItem);
      }
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public int getNumberOfRows(){
    int count = 0;
    try {
      ResultSet rs = connection.get().createStatement().executeQuery("SELECT count(*) from cookies");
      while (rs.next()){
        count = rs.getInt("count");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return count;
  }
}
