package login;

import SQL.SQLConnector;
import savebutton.SaveButton;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = "";
        String pw = "";

        email = request.getParameter("email");
        pw = request.getParameter("pw");

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


        if (dbPass != "" && dbPass.equals(pw))
        {
            Cookie loginCookie = new Cookie("user", email);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            SaveButton saveButton = new SaveButton();
            SQLConnector sqll = new SQLConnector();
            ResultSet rss = null;
            String emails = saveButton.getCookie(request);
            rss = sqll.getData("SELECT name FROM users WHERE email = '" + emails + "';");

            try
            {
                if (rss.next())
                {
                    String shitname = rss.getString(1);
                    request.setAttribute("username", shitname);
                    RequestDispatcher disp = request.getRequestDispatcher("/MainPagee.jsp");
                    disp.forward(request, response);
                } else
                {
                    RequestDispatcher wrongpw = request.getRequestDispatcher("wrongpw.html");
                    wrongpw.include(request, response);
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            return;
        }
    }
}