package com.clouway;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class JettyServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    WebAppContext webapp = new WebAppContext();
    webapp.setWar("src/main/webapp/");
    server.setHandler(webapp);
    server.start();
    server.join();
  }
}
