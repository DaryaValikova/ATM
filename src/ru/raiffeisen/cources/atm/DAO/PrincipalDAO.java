package ru.raiffeisen.cources.atm.DAO;

import ru.raiffeisen.cources.atm.connection.IConnectionManager;
import ru.raiffeisen.cources.atm.model.account.Principal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrincipalDAO extends AbstractDAO{

    public PrincipalDAO(IConnectionManager connectionManager) {
        super(connectionManager);
    }

    public List<Principal> principalArray() {
        List<Principal> principals = new ArrayList<>();

        Statement statement = null;

        try{
            statement = super.connectionManager.getConnection()
                    .createStatement();

            ResultSet rs = statement.executeQuery("select \"lastName\",\"firstName\", \"secondName\", \"age\" from public.principal"
            );

            while (rs.next()) {
                Principal principal = new Principal(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getShort(4));

                principals.add(principal);
            }
        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }

        return principals;
    }
}
