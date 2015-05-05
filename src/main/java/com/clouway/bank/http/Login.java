package com.clouway.bank.http;

import com.clouway.bank.CurrentUser;
import com.clouway.bank.db.SessionRepository;
import com.clouway.bank.validators.UserValidator;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Post;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@At("/login")
@Show("login.html")
public class Login {
  public String username;
  public String password;
  public String message;

  private UserValidator validator;
  private HttpServletResponse response;
  private CurrentUser currentUser;


  @Inject
  public Login(UserValidator validator, HttpServletResponse response, CurrentUser currentUser) {
    this.validator = validator;
    this.response = response;
    this.currentUser = currentUser;
  }

  @Post
  public Reply<?> post(){
    boolean isValid = validator.isValid(username, password);
    if (!isValid || currentUser.findUser(username, password) == null) {
      message = "Invalid username or password";
      return null;
    }
    String sid = currentUser.getSid();
    if (sid == null || currentUser.getSession() == null) {
      UUID uuid = new UUID(10, 5);
      String randomValue = username + uuid.randomUUID().toString() + "qwerty";
      sid = sha1(randomValue);
      response.addCookie(new Cookie("sid", sid));
      currentUser.registerCookie(username, sid);
    }
    currentUser.refreshCookie(username);
    return Reply.saying().redirect("/welcome");
  }

  static String sha1(String input) {
    MessageDigest mDigest = null;
    try {
      mDigest = MessageDigest.getInstance("SHA1");
    } catch (NoSuchAlgorithmException e) {
      return "";
    }

    byte[] result = mDigest.digest(input.getBytes());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < result.length; i++) {
      sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
    }

    return sb.toString();
  }
}
