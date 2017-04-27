package login;

import SQL.SQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jakubinyi on 2017.04.27..
 */
public class LoginService {
    public String[] sqlQuery(String email) {
        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT password, name FROM users WHERE email = '" + email + "'");
        String dbPass = "";
        String dbName = "";

        try
        {
            if (rs.next())
            {
                dbPass = rs.getString(1);
                dbName = rs.getString(2);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        String[] datasFromDatabase = new String[] {dbPass, dbName};
        return datasFromDatabase;
    }
}
