package publishbutton;

import SQL.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikolett on 2017.04.12..
 */
@WebServlet(name = "PublishButton")
public class PublishButton extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        SQLConnector sql = new SQLConnector();
        sql.sendQuery("UPDATE curriculum SET ispublished = '1' WHERE title = 'SQL';");


        request.getRequestDispatcher("/MainPagee.jsp").forward(request, response);

    }
}
