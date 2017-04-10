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
    <h4 class="change-user">Change username:
        <input class="change-user-name" type="text" id="changeuser" placeholder=<%=userName%>/><br/>
    </h4>
    <h4 class="change-role">
        Change role:
        <input class="change-role" type="radio" name="role" value="student"/>Student
        <input class="change-role" type="radio" name="role" value="mentor"/>Mentor
    </h4>
    <input class="save-button" type="submit" value="Save"/>
</div>
</body>
</html>