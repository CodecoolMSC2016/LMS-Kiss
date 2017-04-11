package userPage;

import SQL.SQLConnector;
import savebutton.SaveButton;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kabaly on 4/10/17.
 */
@WebServlet(name = "UserPage")
public class UserPage extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		RequestDispatcher wrongpw=request.getRequestDispatcher("userPagee.jsp");
		wrongpw.forward(request,response);
	}

}
