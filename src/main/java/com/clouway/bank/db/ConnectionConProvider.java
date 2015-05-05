package com.clouway.bank.db;

import com.clouway.bank.filters.ConnectionFilter;

import java.sql.Connection;

/**
 * @author Dimitar Dimitrov (dimitar.dimitrov045@gmail.com)
 */
public class ConnectionConProvider implements ConProvider<Connection> {

    @Override
    public Connection get() {
      return ConnectionFilter.connectionThreadLocal.get();
    }

}
