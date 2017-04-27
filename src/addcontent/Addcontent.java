package addcontent;

import SQL.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikolett on 2017.04.27..
 */
@WebServlet(name = "Addcontent")
public class Addcontent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SQLConnector sql = new SQLConnector();

        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String id = request.getParameter("newid");
        sql.sendQuery("INSERT into curriculum (idcurriculum, ispublished, title, contenttype, content) VALUES ('" + id + "', '0' ,'" + title + "','" + type + "', 'text');");

        request.getRequestDispatcher("/curriculum.jsp").include(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
