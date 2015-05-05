package com.clouway.bank.db;

import com.clouway.bank.History;
import com.google.inject.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class PersistentHistoryRepository implements HistoryRepository {
  private DataStore dataStore;

  @Inject
  public PersistentHistoryRepository(DataStore dataStore) {
    this.dataStore = dataStore;
  }

  @Override
  public List<History> getLastTransactions(String name, int page) {
    return dataStore.fetchRows("SELECT * FROM history WHERE name = '" + name + "' ORDER by date DESC limit 5 offset " + page + " ", new RowFetcher<History>() {
      @Override
      public History fetchRow(ResultSet rs) throws SQLException {
        String transaction = rs.getString("transaction");
        String before_transaction = rs.getString("before_transaction");
        String after_transaction = rs.getString("after_transaction");
        String date = rs.getString("date");
        String name = rs.getString("name");
        return new History(transaction, before_transaction, after_transaction, date, name);
      }
    });
  }
}
