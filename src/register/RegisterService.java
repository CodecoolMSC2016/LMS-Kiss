package register;

import SQL.SQLConnector;

/**
 * Created by jakubinyi on 2017.04.27..
 */
public class RegisterService {
    public void sqlInsert(String email, String pw, String role, String name) {
        SQLConnector sql = new SQLConnector();
        sql.sendQuery("INSERT INTO users VALUES ('0', '" + email + "',sha1('" + pw + "'), '" + role + "', '" + name + "');");
    }
}
