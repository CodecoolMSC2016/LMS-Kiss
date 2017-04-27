package test;

import SQL.SQLConnector;
import login.DataType;
import login.Login;
import login.LoginService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import register.RegisterService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jakubinyi on 2017.04.27..
 */
public class TestLogin {
    @Test
    public void testLogin() {
        String email = "aaa@aaa.com";
        String pw = "aaa";
        String role = "student";
        String name = "aaa";

        RegisterService registerService = new RegisterService();
        registerService.sqlInsert(email, pw, role, name);

        LoginService loginService = new LoginService();
        String[] datasFromDatabase = loginService.sqlQuery(email);

        Login login = new Login();
        String password = login.sha1(pw);

        assertEquals(password.toLowerCase(), datasFromDatabase[DataType.PASSWORD.getValue()]);
    }

    @AfterAll
    public static void deleteTestDatasFromSQL() {
        String email = "aaa@aaa.com";
        SQLConnector sql = new SQLConnector();
        sql.sendQuery("DELETE FROM users WHERE email = '" + email + "';");
    }
}
