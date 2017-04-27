<%--
  Created by IntelliJ IDEA.
  User: kabaly
  Date: 4/26/17
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User List</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
    body, h1, h2, h3, h4, h5, h6 {
        font-family: "Montserrat", sans-serif;
        background-image: url("wall.jpg") !important;
    }

    .w3-row-padding img {
        margin-bottom: 12px
    }

    .w3-sidebar {
        width: 120px;
        background: #222;
    }

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
        <i class="fa fa-address-card-o w3-xxlarge"></i>
        <p>USER PAGE</p>
    </a>
    <a href="curriculumviewstudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-file-text-o w3-xxlarge"></i>
        <p>CURR. VIEW</p>
    </a>
    <a href="index.html" class="w3-bar-item w3-button w3-padding-large w3-hover-black" name="button4">
        <i class="fa fa-power-off w3-xxlarge"></i>
        <p>LOG OUT</p>
    </a>
</nav>

<%@ page import="java.sql.*" %>

<%
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://127.0.0.1:3306/";
    String dbName = "lms";
    String userId = "root";
    String password = "admin";

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

%>

<h2 align="center"><font color="black"><strong>User List:</strong></font></h2>
<table width="40%" align="center" cellpadding="7" cellspacing="6" border="1">
    <tr>
    </tr>
    <tr bgcolor="#A52A2A">
        <td><b>Email</b></td>
        <td><b>Role</b></td>
        <td><b>Name</b></td>
    </tr>
    <%
        try{
            Connection connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
            Statement statement = connection.createStatement();

            String roleQuery = "SELECT role FROM users WHERE email = '" + userEmail + "'";
            ResultSet roleResult = statement.executeQuery(roleQuery);

            roleResult.next();
            String roleUser = roleResult.getString(1);
            String sql = "";

            if (roleUser.equals("student")) {
                sql ="SELECT email, role, name FROM users WHERE role = '" + roleUser + "'";
            }
            else {
                sql ="SELECT email, role, name FROM users";
            }

            ResultSet resultSet = statement.executeQuery(sql);
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
