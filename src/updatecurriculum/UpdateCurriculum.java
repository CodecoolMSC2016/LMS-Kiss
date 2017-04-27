package updatecurriculum;

import SQL.SQLConnector;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "UpdateCurriculum")
public class UpdateCurriculum extends HttpServlet {

    ObjectMapper role = new ObjectMapper();

    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT role FROM users WHERE email = '" + getCookie(request) + "'");
        String dbRole = "";

        String getContent = "";

        String writeout= "";

        try {
            if (rs.next()) {
                dbRole = rs.getString(1);
                if (dbRole.equals("student")) {

                   role.writer().writeValue(response.getOutputStream(), "student");

                }

                if (dbRole.equals("mentor")) {

                    role.writer().writeValue(response.getOutputStream(), "mentor");
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
