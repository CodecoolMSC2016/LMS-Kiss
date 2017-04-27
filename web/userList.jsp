<%--
  Created by IntelliJ IDEA.
  User: kabaly
  Date: 4/26/17
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<meta contentType="text/html;charset=UTF-8" language="java">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User List</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
    body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
    .w3-row-padding img {margin-bottom: 12px}
    /* Set the width of the sidebar to 120px */
    .w3-sidebar {width: 120px;background: #222;}
    /* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
    #main {margin-left: 120px}
    /* Remove margins from "page content" on small screens */
    @media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>

<body class="w3-black" style="margin-top: -10px">
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
    <a href="MainPagee.jsp" class="w3-bar-item w3-button w3-padding-large w3-black">
        <i class="fa fa-home w3-xxlarge"></i>
        <p>HOME</p>
    </a>
    <a href="userList.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-user w3-xxlarge"></i>
        <p>USER LIST</p>
    </a>
    <a href="userPagee.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-eye w3-xxlarge"></i>
        <p>USER PAGE</p>
    </a>
    <a href="curriculumviewstudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-envelope w3-xxlarge"></i>
        <p>CURR. VIEW</p>
    </a>
</nav>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://127.0.0.1:3306/";
    String dbName = "lms";
    String userId = "root";
    String password = "root";

    String userEmail = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userEmail = cookie.getValue();
        }
    }

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>

<h2 align="center"><font><strong>User List:</strong></font></h2>
<table width="40%" align="center" cellpadding="8" cellspacing="6" border="1">
    <tr>
    </tr>
    <tr bgcolor="#A52A2A">
        <td><b>Email</b></td>
        <td><b>Role</b></td>
        <td><b>Name</b></td>
    </tr>
    <%
        try{
            connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
            statement = connection.createStatement();

            String roleQuery = "SELECT role FROM users WHERE email = '" + userEmail + "'";

            //String sql ="SELECT email, role, name FROM users WHERE role = '" + roleQuery + "'";
            String sql ="SELECT email, role, name FROM users";
            //System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
    %>
    <tr bgcolor="#160c00">

        <td><%=resultSet.getString("email") %></td>
        <td><%=resultSet.getString("role") %></td>
        <td><%=resultSet.getString("name") %></td>

    </tr>

    <%
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

</table>
</body>
</html>
