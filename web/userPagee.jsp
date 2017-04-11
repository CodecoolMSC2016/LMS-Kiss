<%--
  Created by IntelliJ IDEA.
  User: sziszka
  Date: 2017.04.10.
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }
        if(userName == null) response.sendRedirect("login.html");
    %>
    <link rel="stylesheet" type="text/css" href="userpage.css">
    <meta charset="UTF-8">
    <title>User Page</title>
</head>
<body>
<div class="main">
    <h1 class="userpage">User page</h1>
    <form action="/savebutton" method="post">
    <h4 class="user-name">Username:
        <input class="user-name" type="text" id="changeuser" placeholder=<%=userName%>/><br/>
    </h4>
    <h4 class="user-email">User email:
        <input class="user-email" readonly type="text" placeholder=<%=userName%>/><br/>
    </h4>
    <h4 class="user-role">Role:
        <input class="user-role" type="radio" name="role" value="student"/>Student
        <input class="user-role" type="radio" name="role" value="mentor"/>Mentor
    </h4>
        <input class="save-button" name="savebutton" type="submit" value="Save"/>
    </form>
</div>
</body>
</html>
