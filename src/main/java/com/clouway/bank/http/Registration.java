package com.clouway.bank.http;

import com.clouway.bank.db.UserRepository;
import com.clouway.bank.validators.UserValidator;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Post;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@At("/registration")
@Show("registration.html")
public class Registration {
  public String username;
  public String password;
  public String message;
  private UserValidator validator;
  private UserRepository userRepository;

  @Inject
  public Registration(UserValidator validator, UserRepository userRepository) {
    this.validator = validator;
    this.userRepository = userRepository;
  }

  @Post
  public void post(){
    boolean isValid = validator.isValid(username, password);
    // invalid username or password
    if(!isValid){
      message = "Invalid Username or Password";
      return;
    }
    boolean isValidUser = userRepository.registerUser(username, password, 0.0);
    // error with database
    if (!isValidUser){
      message = "The username already exist";
      return;
    }
    message = "The registration is successful";
  }
}
