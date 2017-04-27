package savebutton;

import SQL.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lugos on 2017. 04. 10..
 */
public class SaveButton extends HttpServlet
{
	public String getCookie(HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String newName = "";
		newName = request.getParameter("changeuser");
		System.out.println(newName);

		System.out.println("EMAIL: " + getCookie(request));

		SQLConnector sql = new SQLConnector();
		sql.sendQuery("UPDATE users SET name = '" + newName + "' WHERE email = '" + getCookie(request) + "';");

		request.getRequestDispatcher("./userPage").forward(request, response);
	}
}
