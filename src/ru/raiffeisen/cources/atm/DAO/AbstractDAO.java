package ru.raiffeisen.cources.atm.DAO;

import ru.raiffeisen.cources.atm.connection.IConnectionManager;

public abstract class AbstractDAO {
    private static boolean IS_DRIVER_ACCESSIBLE;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            IS_DRIVER_ACCESSIBLE = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            IS_DRIVER_ACCESSIBLE = false;
        }
    }

    public static boolean isIsDriverAccessible() {
        return IS_DRIVER_ACCESSIBLE;
    }

    protected IConnectionManager connectionManager;

    public AbstractDAO(IConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
