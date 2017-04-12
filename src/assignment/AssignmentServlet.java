package assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssignmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        request.getRequestDispatcher("./points.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int point = 0;
        String q1 = "";
        String q2 = "";
        String q3 = "";
        String q4 = "";
        String q5 = "";

        q1 = request.getParameter("q1");
        if ("c".equals(q1)) {
            point++;
        }
        q2 = request.getParameter("q2");
        if ("a".equals(q2)) {
            point++;
        }
        q3 = request.getParameter("q3");
        if ("c".equals(q3)) {
            point++;
        }
        q4 = request.getParameter("q4");
        if ("d".equals(q4)) {
            point++;
        }
        q5 = request.getParameter("q5");
        if ("b".equals(q5)) {
            point++;
        }

        if (q1 == null  || q2 == null || q3 == null || q4 == null || q5 == null) {
            String hTMLResponse = "<script type='text/javascript'>alert('Minden mező kitöltése kötelező')</script>";
            request.setAttribute("error", hTMLResponse);
            request.getRequestDispatcher("./assignment.jsp").forward(request, response);
            return;
        }


        request.setAttribute("point", point);
        request.getRequestDispatcher("./points.jsp").forward(request, response);

    }

}
