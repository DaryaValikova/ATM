package ru.raiffeisen.cources.atm.connection;


import ru.raiffeisen.cources.atm.DAO.PrincipalDAO;

public class Main {
    public static void main(String[] args) {
        PrincipalDAO principalDAO = new PrincipalDAO(
                                        new PooledConnectionManager(20)
        );

        System.out.println(principalDAO.principalArray());
    }
}
