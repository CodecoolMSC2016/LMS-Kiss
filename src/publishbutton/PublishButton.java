package publishbutton;

import SQL.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PublishButton")
public class PublishButton extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SQLConnector sql = new SQLConnector();
        String currID = request.getParameter("id");
        String data = request.getParameter("data");
        System.out.println(currID);
        System.out.println(data);
        sql.sendQuery("UPDATE curriculum SET ispublished = '1' WHERE idcurriculum = '" + currID +"';");
        sql.sendQuery("UPDATE curriculum SET content = '" +data +"' WHERE idcurriculum = '" + currID +"';");



        request.getRequestDispatcher("/curriculum.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
