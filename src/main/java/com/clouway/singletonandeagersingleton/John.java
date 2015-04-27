package com.clouway.singletonandeagersingleton;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class John implements Person {

  public John() {
    System.out.println("The John is created");
  }

  public void talk() {
    System.out.println("The person John is talking");
  }
}
