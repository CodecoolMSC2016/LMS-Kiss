package register;

import SQL.SQLConnector;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void registerToFile(HttpServletRequest request) throws IOException{
        String email = "";
        String pw = "";
        String role = "";
        String name = "";

        email = request.getParameter("email");
        pw = request.getParameter("pw");
        role = request.getParameter("role");
        name = request.getParameter("name");

        SQLConnector sql = new SQLConnector();
        sql.sendQuery("INSERT INTO users VALUES ('0', '" + email + "', '" + pw + "', '" + role + "', '" + name + "');");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        registerToFile(request);
        RequestDispatcher success=request.getRequestDispatcher("registered.html");
        success.include(request,response);
    }


}
