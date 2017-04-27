package curriculum;

import SQL.SQLConnector;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Curriculum")
public class Curriculum extends HttpServlet {
    ObjectMapper getList = new ObjectMapper();
    ArrayList<Data> titlesStudent;
    ArrayList<Data> titlesMentor;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs = null;
        SQLConnector sql = new SQLConnector();
        rs = sql.getData("SELECT role FROM users WHERE email = '" + getCookie(request) + "'");
        String dbRole = "";
        response.setContentType("application/json, charset=UTF-8");

        try {
            if (rs.next()) {
                dbRole = rs.getString(1);
                if (dbRole.equals("student")) {

                    getList.writer().writeValue(response.getOutputStream(), getContentStudent());

                }

                if (dbRole.equals("mentor")) {
                    getList.writer().writeValue(response.getOutputStream(), getContentMentor());

                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Data> getContentStudent() throws SQLException {

        titlesStudent = new ArrayList<Data>();
        SQLConnector sql = new SQLConnector();

        ResultSet getTitlesStudent = null;
        getTitlesStudent = sql.getData("SELECT idcurriculum, ispublished, title, contenttype, content FROM curriculum WHERE ispublished = 1");

        try {
            while (getTitlesStudent.next()) {
                int id=getTitlesStudent.getInt("idcurriculum");
                String title = getTitlesStudent.getString("title");
                String contenttype = getTitlesStudent.getString("contenttype");
                int ispublished = getTitlesStudent.getInt("ispublished");
                String content = getTitlesStudent.getString("content");
                titlesStudent.add(new Data(id, title, contenttype, ispublished, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return titlesStudent;
    }

    protected ArrayList<Data> getContentMentor() throws SQLException{
        titlesMentor = new ArrayList<Data>();
        SQLConnector sql = new SQLConnector();

        ResultSet getTitlesMentor = null;
        getTitlesMentor = sql.getData("SELECT idcurriculum, ispublished, title, contenttype, content FROM curriculum");

        try {
            while (getTitlesMentor.next()) {
                int id=getTitlesMentor.getInt("idcurriculum");
                String title = getTitlesMentor.getString("title");
                String contenttype = getTitlesMentor.getString("contenttype");
                int ispublished = getTitlesMentor.getInt("ispublished");
                String content = getTitlesMentor.getString("content");
                titlesMentor.add(new Data(id, title, contenttype, ispublished, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return titlesMentor;
    }
}
