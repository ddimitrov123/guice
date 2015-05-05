package com.clouway.bank.http;

import com.clouway.bank.CurrentUser;
import com.clouway.bank.db.Session;
import com.clouway.bank.validators.NumberValidator;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;

import java.math.BigDecimal;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@At("/welcome")
@Show("welcome.html")
public class Welcome {
  public String deposit;
  public String withdraw;
  public String display;

  private NumberValidator numberValidator;
  private final CurrentUser currentUser;

  @Inject
  public Welcome(NumberValidator numberValidator, CurrentUser currentUser) {
    this.numberValidator = numberValidator;
    this.currentUser = currentUser;
  }

  @Get
  public void get() {
    display = currentUser.findBalance().toString();
  }

  @Post
  public Reply<?> post() {
    boolean isValid = numberValidator.isValid(deposit, withdraw);
    if (!isValid) {
      return Reply.saying().redirect("/welcome");
    }
    if (!"".equals(deposit) && "".equals(withdraw)) {
      Double balance = currentUser.findBalance();
      Double parsedDeposit = Double.parseDouble(deposit);
      BigDecimal decimal = BigDecimal.valueOf(parsedDeposit).add(BigDecimal.valueOf(balance));
      Double amount = Double.parseDouble(String.valueOf(decimal));
      currentUser.updateBalance(amount);
    }
    if (!"".equals(withdraw) && "".equals(deposit)) {
      Double balance = currentUser.findBalance();
      Double parsedWithdraw = Double.parseDouble(withdraw);
      if (balance < parsedWithdraw) {
        return Reply.saying().redirect("/welcome");
      }
      BigDecimal decimal = BigDecimal.valueOf(balance).subtract(BigDecimal.valueOf(parsedWithdraw));
      Double amount = Double.parseDouble(String.valueOf(decimal));
      currentUser.updateBalance(amount);
    }
    return Reply.saying().redirect("/welcome");
  }
}
