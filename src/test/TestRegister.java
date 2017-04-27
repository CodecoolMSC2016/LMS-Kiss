package test;

import SQL.SQLConnector;
import login.Login;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import register.RegisterService;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jakubinyi on 2017.04.27..
 */
public class TestRegister {


    @Test
    public void testRegister() {
        String email = "aaa@aaa.com";
        String pw = "aaa";
        String role = "student";
        String name = "aaa";

        RegisterService registerService = new RegisterService();
        registerService.sqlInsert(email, pw, role, name);

        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT password, name FROM users WHERE email = '" + email + "'");
        String dbPass = "";
        String dbName = "";

        try {
            if (rs.next()) {
                dbPass = rs.getString(1);
                dbName = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Login login = new Login();
        String pass = login.sha1(pw);

        assertEquals(pass.toLowerCase(), dbPass);
    }

    @AfterAll
    public static void deleteTestDatasFromSQL() {
        String email = "aaa@aaa.com";
        SQLConnector sql = new SQLConnector();
        sql.sendQuery("DELETE FROM users WHERE email = '" + email + "';");
    }
}
