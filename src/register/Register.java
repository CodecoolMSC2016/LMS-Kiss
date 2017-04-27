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
        String email = request.getParameter("email");
        String pw = request.getParameter("pw");
        String role = request.getParameter("role");
        String name = request.getParameter("name");

        RegisterService rs = new RegisterService();
        rs.sqlInsert(email, pw, role, name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        registerToFile(request);
        RequestDispatcher success=request.getRequestDispatcher("login.jsp");
        success.include(request,response);
    }


}
