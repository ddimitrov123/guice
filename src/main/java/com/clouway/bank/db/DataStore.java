package com.clouway.bank.db;

import com.google.inject.Inject;

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
  private ConProvider<Connection> conProvider;

  @Inject
  public DataStore(ConProvider conProvider) {
    this.conProvider = conProvider;
  }

  public boolean execute(String query) {
    Connection connection = conProvider.get();
    try {
      connection.createStatement().execute(query);
    } catch (SQLException e) {
      return false;
    }
    return true;
  }

  public <T> T fetchRow(String query, RowFetcher<T> fetcher) {
    Connection connection = conProvider.get();
    T rowItem = null;
    try {
      Statement stmt = connection.createStatement();
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
    Connection connection = conProvider.get();
    List<T> result = new ArrayList<T>();
    try {
      Statement stmt = connection.createStatement();
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
}
