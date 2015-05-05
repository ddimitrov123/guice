package com.clouway.bank.http;

import com.clouway.bank.CurrentUser;
import com.clouway.bank.db.HistoryRepository;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@At("/history")
@Show("history.html")
public class History {
  public List<com.clouway.bank.History> history = new ArrayList<com.clouway.bank.History>();
  public int page = 0;
  private HistoryRepository historyRepository;
  private CurrentUser currentUser;

  @Inject
  public History(HistoryRepository historyRepository, CurrentUser currentUser) {
    this.historyRepository = historyRepository;
    this.currentUser = currentUser;
  }

  @Get
  public String get() {
    if (page < 0) {
      return "/history?page=0";
    }
    int offset = page * 5;
    history = historyRepository.getLastTransactions(currentUser.getUsername(), offset);
    if (history.size() == 0){
      return "/history?page=" + (page - 1);
    }
    return null;
  }
}
