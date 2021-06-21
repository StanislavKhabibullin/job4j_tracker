package ru.job4j.tracker;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionRollback {

    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
          ConnectionRollback.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, methods, args) -> {
              Object rsl = null;
              if ("close".equals(methods.getName())) {
                  connection.rollback();
                  connection.close();
              } else {
                  rsl = methods.invoke(connection, args);
              }
              return rsl;
                }
        );
    }
}
