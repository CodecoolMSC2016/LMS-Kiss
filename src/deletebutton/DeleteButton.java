package deletebutton;

import SQL.SQLConnector;
import login.Login;
import savebutton.SaveButton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lugos on 2017. 04. 24..
 */
@WebServlet(name = "DeleteButton")
public class DeleteButton extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login login = new Login();

		SaveButton sb = new SaveButton();
		SQLConnector sql = new SQLConnector();
		String pw = request.getParameter("delete");
		ResultSet password = sql.getData("SELECT password FROM users WHERE email = '" + sb.getCookie(request) + "';");
		String dbPass = "";
		String dbName = "";
		String error = "<script type='text/javascript'>alert('Wrong password!')</script>";

		try {
			if (password.next()) {
				dbPass = password.getString(1);
				dbName = password.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		if (dbPass != "" && dbPass.equalsIgnoreCase(login.sha1(pw))) {
			sql.sendQuery("DELETE FROM users WHERE email = '" + sb.getCookie(request) + "';");
			request.getRequestDispatcher("./index.html").forward(request, response);
		} else {
			request.setAttribute("error", error);
			request.getRequestDispatcher("./userPagee.jsp").forward(request, response);
		}

	}
}
