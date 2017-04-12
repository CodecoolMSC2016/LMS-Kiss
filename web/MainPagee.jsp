<%--
  Created by IntelliJ IDEA.
  User: lugos
  Date: 2017. 04. 10.
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="loggedin.css" rel="stylesheet" type="text/css" >
    <style type="text/css" >
        body {
            background-color: #DADADA;
        }
    </style>
</head>
<body>
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
<table width="1000" border="0" align="left" cellpadding="0" cellspacing="0">
    <tr>
        <td><img src="logged_images/spacer.gif" width="199" height="1" border="0" alt="" /></td>
        <td><img src="logged_images/spacer.gif" width="26" height="1" border="0" alt="" /></td>
        <td><img src="logged_images/spacer.gif" width="733" height="1" border="0" alt="" /></td>

        <td><img src="logged_images/spacer.gif" width="42" height="1" border="0" alt="" /></td>
        <td><img src="logged_images/spacer.gif" width="1" height="1" border="0" alt="" /></td>
    </tr> <tr> <td colspan="4"><img name="header" src="logged_images/header.png" width="1000" height="207" border="0" id="header" alt="" /></td>
    <td><img src="logged_images/spacer.gif" width="1" height="207" border="0" alt="" /></td>
</tr> <tr> <td><img name="cc" src="logged_images/cc.png" width="199" height="98" border="0" id="cc" alt="" /></td>
    <td rowspan="2" background="logged_images/left_space.png">&nbsp;</td>
    <td rowspan="2" valign="top" bgcolor="#FFFFFF">&nbsp; <img src="logged_images/timeline.png" height="25%" width="100%"> </td>
    <td rowspan="2" background="logged_images/right_space.png">&nbsp;</td> <td><img src="logged_images/spacer.gif" width="1" height="98" border="0" alt="" /></td>
</tr> <tr> <td rowspan="3" valign="top" bgcolor="#737373">&nbsp;
    <form action="/table" method="post" target="_blank">
        <br>
        <div>
            <p>Username: ${username}</p>
        </div>
        <br>
        <input type="submit" class="button" value="Users List" name ="button1">
    </form>
    <form action="/userPage" method="post">
        <input type="submit" class="button" value="User Page" name="button2">
    </form>
    <form action="/curriculum" method="post">
        <input type="submit" class="button" value="Curriculum View" name="button3">
    </form>
</td> <td><img src="logged_images/spacer.gif" width="1" height="412" border="0" alt="" /></td>
</tr> <tr> <td colspan="3"><img name="line" src="logged_images/line.png" width="801" height="25" border="0" id="line" alt="" /></td>
    <td><img src="logged_images/spacer.gif" width="1" height="25" border="0" alt="" /></td> </tr> <tr>
    <td colspan="3" background="logged_images/footer.png">&nbsp;
        "<center><strong>2017 © Kis(s) - Codecool's Learning Management System </strong></center>
        "</td>"
    <td><img src="logged_images/spacer.gif" width="1" height="18" border="0" alt="" /></td> </tr> </table> </body> </html>
</body>
</html>