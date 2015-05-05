package com.clouway.bank.db;

import com.clouway.bank.History;

import java.util.List;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public interface HistoryRepository {
  List<History> getLastTransactions(String name, int page);
}
