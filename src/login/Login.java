package login;

import SQL.SQLConnector;
import savebutton.SaveButton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.xml.bind.DatatypeConverter;

@WebServlet(name = "Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("email");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");

        LoginService ls = new LoginService();
        String[] datasFromDatabase = ls.sqlQuery(email);

        if (datasFromDatabase[DataType.PASSWORD.getValue()] != "" && datasFromDatabase[DataType.PASSWORD.getValue()].equalsIgnoreCase(sha1(pw)))
        {
            Cookie loginCookie = new Cookie("user", email);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            Cookie loginsCookie = new Cookie("username", name);
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
                }

            } catch (SQLException e)
            {
                e.printStackTrace();
            }


            return;
        }
        else
        {
            request.setAttribute("message", "Wrong Email or Password!");
            RequestDispatcher wrongpw = request.getRequestDispatcher("login.jsp");
            wrongpw.include(request, response);
        }
    }
}