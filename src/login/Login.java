package login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CSVHandling readCsv = new CSVHandling();
        ArrayList<UserInfo> log = readCsv.CSVReader(request.getServletContext().getRealPath("logins.csv"));
        UserInfo user = new UserInfo(request.getParameter("email"), request.getParameter("pw"), "", request
                .getParameter("name"));

        for(int i = 0; i < log.size(); i++){
            if(log.get(i).email.equals(user.email)){
                if(log.get(i).password.equals(user.password)){
                    Cookie loginCookie = new Cookie("user",user.email);
                    loginCookie.setMaxAge(30*60);
                    response.addCookie(loginCookie);
                    response.sendRedirect("MainPagee.jsp");

                    FileWriter writer = new FileWriter(request.getServletContext().getRealPath("currentuser.csv"));

                    writer.append(request.getParameter("email"));
                    writer.append(", ");
                    writer.append(request.getParameter("pw"));
                    writer.append(", ");

                    writer.append(log.get(i).role);
                    writer.append(", ");
                    writer.append(log.get(i).name);
                    writer.append('\n');

                    writer.flush();
                    writer.close();
                    break;
                }
                else{
                    RequestDispatcher wrongpw=request.getRequestDispatcher("wrongpw.html");
                    wrongpw.include(request,response);
                    break;

                }
            }
            else{
                if(i == log.size()-1) {
                    RequestDispatcher wronguserandpw = request.getRequestDispatcher("wronguserandpw.html");
                    wronguserandpw.include(request, response);
                }
            }
        }

    }
}
