package com.clouway.bank.filters;

import com.google.inject.Singleton;
import org.postgresql.ds.PGPoolingDataSource;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
@Singleton
public class ConnectionFilter implements Filter {
  public final static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
  private PGPoolingDataSource source = new PGPoolingDataSource();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    source.setServerName("localhost");
    source.setDatabaseName("bank");
    source.setUser("postgres");
    source.setPassword("123456");
    source.setMaxConnections(10);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (connectionThreadLocal.get() == null) {
      Connection connection = getConnection();
      if (connection == null) {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.sendRedirect("/error.html");
        return;
      }
      connectionThreadLocal.set(connection);
    }
    filterChain.doFilter(servletRequest, servletResponse);

    Connection conn = connectionThreadLocal.get();
    try {
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connectionThreadLocal.set(null);
  }

  @Override
  public void destroy() {

  }

  private Connection getConnection() {
    Connection connection = null;
    try {
      connection = source.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}
