package ru.raiffeisen.cources.atm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PooledConnectionManager implements IConnectionManager {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/ATM";
    public static final String USER_NAME = "postgres";
    public static final String USER_PASSWORD = "admin";

    private Map<Integer, Connection> connectionPool =
            new HashMap<>();
    private int poolCapacity;

    public PooledConnectionManager(int poolCapacity) {
        this.poolCapacity = poolCapacity;

        for (int i = 0; i < poolCapacity; i++) {
            try {
                Connection connection =
                        DriverManager
                                .getConnection(DB_URL,
                                        USER_NAME, USER_PASSWORD);

                connectionPool.put(i, connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() {
        Integer firstKey = connectionPool.keySet().iterator().next();

        Connection connection = connectionPool.get(firstKey);
        connectionPool.remove(firstKey);

        return connection;
    }

    public void returnConnection(Connection connection){
        Integer newKey = 0;
        for (Integer key:
             connectionPool.keySet()) {
            newKey = key;
        }
        newKey++;

        connectionPool.put(newKey, connection);
    }
}
