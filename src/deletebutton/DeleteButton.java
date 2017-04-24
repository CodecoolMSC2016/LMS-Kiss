package deletebutton;

import SQL.SQLConnector;
import savebutton.SaveButton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lugos on 2017. 04. 24..
 */
@WebServlet(name = "DeleteButton")
public class DeleteButton extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		SaveButton sb = new SaveButton();
		SQLConnector sql = new SQLConnector();
		sql.sendQuery("DELETE FROM users WHERE email = '" + sb.getCookie(request) + "';");
		request.getRequestDispatcher("./index.html").forward(request, response);
	}

}
