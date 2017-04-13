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
    ArrayList<String> titlesStudent;
    ArrayList<String> titlesMentor;

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

        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT role FROM users WHERE email = '" + getCookie(request) + "'");
        String dbRole = "";

        String getContent = "";


        PrintWriter out = response.getWriter();

        String writeout= "";

        try {
            if (rs.next()) {
                dbRole = rs.getString(1);
                if (dbRole.equals("student")) {

                    writeout = getStart() + getContentStudent() + getEnd();

                }

                if (dbRole.equals("mentor")) {
                    writeout= getStart() + getContentStudent() + getContentMentor() + getEnd();
                }


            }
            out.print(writeout);
        } catch (SQLException e) {
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

                "<script>" +
                "var myW;" +
                "function submitCurr() {" +
                "document.getElementById(\"publish\").style.display = \"none\";}"
                +"</script>" +


                "<body>" +
                "<div class=\"main\">" +
                "<h1>" + " Your Curriculum page" + "</h1>";

        return page;
    }
    protected String getEnd(){
        String page = "";
        page += "</div>" +
                "</body>" +
                "</html>";

        return page;
    }
    
    protected String getContentStudent() throws SQLException {

        titlesStudent = new ArrayList<>();
        SQLConnector sql = new SQLConnector();

        ResultSet getTitlesStudent = null;
        getTitlesStudent = sql.getData("SELECT title FROM curriculum WHERE ispublished = 1");

        try {
            while (getTitlesStudent.next()) {
                titlesStudent.add(getTitlesStudent.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        String getContent = "";
        
        for (String title : titlesStudent) {
            ResultSet getContentType = sql.getData("SELECT contenttype FROM curriculum WHERE title = '" + title + "'" );
            String resultContentType = null;
            while(getContentType.next()){
                resultContentType = getContentType.getString(1);
            }
            String link = title.toLowerCase();
            if (link.contains("/")) {
                link = link.replace("/", "");
            }
            if (link.contains(" ")) {
                link = link.replace(" ", "");
            }
            if(resultContentType.equals("text")) {
                getContent += "<input class=\"button\" type=\"button\" onclick=\"openWin(\'textcontent/" + link + ".txt\')\" value=\"" + title + "\" name=\"java\"/><br/>";
            } else {
                getContent += "<input class=\"button\" type=\"submit\" onClick=\"openAssignment(\'assignment.jsp\');\" value=\"" + title + "\" id=\"submit\"/><br/>" +
                        "<a href=\"javascript:openWin(\'assigment.html\')\";></a>";
            }
        }
        return getContent;
    }
    protected String getContentMentor() throws SQLException{
        titlesMentor = new ArrayList<>();
        SQLConnector sql = new SQLConnector();

        ResultSet getTitlesMentor = null;
        getTitlesMentor = sql.getData("SELECT title FROM curriculum WHERE ispublished = 0");

        try {
            while (getTitlesMentor.next()) {
                titlesMentor.add(getTitlesMentor.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String getContent = "";
        for (String title : titlesMentor) {
            ResultSet getContentType = sql.getData("SELECT contenttype FROM curriculum WHERE title = '" + title + "'" );
            String resultContentType = null;

            while(getContentType.next()){
                resultContentType = getContentType.getString(1);
            }
            String link = title.toLowerCase();
            if (link.contains("/")) {
                link = link.replace("/", "");
            }
            if (link.contains(" ")) {
                link = link.replace(" ", "");
            }
            if(resultContentType.equals("text")) {
                getContent += "<input class=\"button\" type=\"button\" onclick=\"openWin(\'textcontent/" + link + ".txt\')\" value=\"" + title + "\" name=\"java\"/>"
                + "<form action=\"publishButton\"><input class=\"publish-button\" type=\"submit\" onClick=\"submitCurr();\" value=\"Publish\" id=\"publish\"/></form><br/><br/>";
            } else {
                getContent += "<input class=\"button\" type=\"submit\" onClick=\"openAssignment(\'assignment.jsp\');\" value=\"" + title + "\" id=\"submit\"/>" +
                        "<a href=\"javascript:openWin(\'assigment.html\')\";></a>" + "<input class=\"publish-button\" type=\"submit\" value=\"Publish\" id=\"publish\"/><br/><br/>"
                ;
            }
        }
        return getContent;
    }
}
