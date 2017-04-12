package curriculum;

import SQL.SQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Curriculum")
public class Curriculum extends HttpServlet {

    public String getCookie(HttpServletRequest request) {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> titlesStudent = new ArrayList<>();
        ArrayList<String> titlesMentor = new ArrayList<>();

        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT role FROM users WHERE email = '" + getCookie(request) + "'");
        String dbRole = "";
        ResultSet getTitlesStudent = null;
        ResultSet getTitlesMentor = null;
        getTitlesStudent = sql.getData("SELECT title FROM curriculum WHERE ispublished = 1");
        getTitlesMentor = sql.getData("SELECT title FROM curriculum WHERE ispublished = 0");

        String getContent = "";


        try {
            while (getTitlesStudent.next()) {
                titlesStudent.add(getTitlesStudent.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (getTitlesMentor.next()) {
                titlesMentor.add(getTitlesMentor.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            PrintWriter out = response.getWriter();

            try {
                if (rs.next()) {
                    dbRole = rs.getString(1);
                    if (dbRole.equals("student")) {

                        for (String title : titlesStudent) {
                            String link = title.toLowerCase();
                            if (link.contains("/")) {
                                link = link.replace("/", "");
                            }
                            getContent += "<input class=\"button\" type=\"button\" onclick=\"openWin(\'textcontent/" + link + ".txt\')\" value=\"" + title + "\" name=\"java\"/><br/>";
                        }
                    }

                    if (dbRole.equals("mentor")) {
                        for (String title : titlesStudent) {
                            String link3 = title.toLowerCase();
                            if (link3.contains("/")) {
                                link3 = link3.replace("/", "");
                            }
                            getContent += "<input class=\"button\" type=\"button\" onclick=\"openWin(\'textcontent/" + link3 + ".txt\')\" value=\"" + title + "\" name=\"java\"/><br/>";

                        }
                        for (String title : titlesMentor) {
                            String link2 = title.toLowerCase();
                                  if (link2.contains("/")) {
                                        link2 = link2.replace("/", "");

                                    }getContent += "<input class=\"button\" type=\"button\" onclick=\"openWin(\'textcontent/" + link2 + ".txt\')\" value=\"" + title + "\" name=\"java\"/><br/>"

                                    + "<input class=\"publish-button\" type=\"submit\" value=\"Publish\"/><br/><br/>";
                            }
                        }
                    }


                out.println(getStart() + getContent + getEnd());
            } catch(SQLException e) {
                e.printStackTrace();
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected String getStart(){
        String page = "";
        page += "<html>" +
                "<head>" +
                "<title>" + "Curriculum view" + "</title>" +
                "<meta charset=\"UTF-8\">" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"curriculumviewstudent.css\">" +
                "</head>" +
                "<script>" +
                "var myWindow;" +
                "function  openWin(url) {" +
                " myWindow = window.open(url, \"myWindow\", \"width=400, height=300\");" +
                "}" +
                "</script>" +

                "<script>" +
                "var myW;" +
        "function openAssignment(url) {" +
                "myW = window.open(url, \"Assignment\", \"width=1500, height=1000\");" +
        "document.getElementById(\"submit\").disabled = true;}"
        +"</script>" +
                "<body>" +
                "<div class=\"main\">" +
                "<h1>" + "Curriculum" + "</h1>" +
                "<h3>" + "Text page" + "</h3>";

        return page;
    }
    protected String getEnd(){
        String page = "";
        page += "<h3>" + "Assignments" + "</h3>" +
                "<input class=\"button\" type=\"submit\" onClick=\"openAssignment(\'assignment.jsp\');\" value=\"Java Assignment\" id=\"submit\"/><br/>" +
                "<a href=\"javascript:openWin(\'assigment.html\')\";></a>" +
                "</div>" +
                "</body>" +
                "</html>";

        return page;
    }
}
