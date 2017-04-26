package tablecontent;

import SQL.SQLConnector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import login.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "TableUList")
public class TableUList extends HttpServlet {

    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("userList.jsp");

        //request.setAttribute("dog", "cat");

        requestDispatcher.forward(request, response);

        SQLConnector sql = new SQLConnector();
        ResultSet rs = sql.getData("SELECT role FROM users WHERE email = '" + getCookie(request) + "'");

        String userRole = "";
        String theContent = "";
        String writeout = "";

        try {

            String email = rs.getString("email");
            String role = rs.getString("role");
            String name = rs.getString("name");

            Gson gson = new Gson();
            UserInfo userInfo = new UserInfo(email, " ", role, name);
            String userJsonInString = gson.toJson(userInfo);

            JsonObject obj = new JsonParser().parse(userJsonInString).getAsJsonObject();
            String emailJ = obj.get("email").getAsString();
            String roleJ = obj.get("role").getAsString();
            String nameJ = obj.get("name").getAsString();

            while (rs.next()) {
                userRole = rs.getString(1);
                if (userRole.equals("student")) {
                    writeout += emailJ + ", " + roleJ + ", " + nameJ + "<br>";
                }
                if (userRole.equals("mentor")) {
                    writeout += emailJ + ", " + roleJ + ", " + nameJ + "<br>";
                }

            }
            out.print(writeout);
        }

        catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }


    public String getStudentData() throws SQLException {

        SQLConnector sql = new SQLConnector();
        ResultSet getStudentRole = null;
        getStudentRole = sql.getData("SELECT email FROM users WHERE role = student");




        return null;
    }


}
