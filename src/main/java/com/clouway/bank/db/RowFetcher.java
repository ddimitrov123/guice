package com.clouway.bank.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface RowFetcher <T> {
  T fetchRow(ResultSet rs) throws SQLException;
}
