package ru.raiffeisen.cources.atm.connection;

import java.sql.Connection;

public interface IConnectionManager {
    Connection getConnection();
}
