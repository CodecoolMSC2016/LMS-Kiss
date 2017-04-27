<%
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }
        if(userName == null) response.sendRedirect("login.jsp");
%>

    <meta charset="UTF-8">
    <title>User Page</title>
<!DOCTYPE html>
<html>
<title>User page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="userpage.css">
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
<body class="w3-black" style="margin-top:-10px">
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
<div class="main">
    <h1 class="userpage">User page</h1>
    <form action="/savebutton" method="post">
        <h4 class="change-user">Change username:
        <input class="change-user-name" type="text" id="changeuser" name="changeuser" placeholder="New username"   ><br/>
    </h4>
        <h4 class="change-user">E-mail:
            <input class="change-email" readonly type="text" placeholder="New e-mail address"   ><br/>
        </h4>
        <h4 class="change-role">
            Change role:
            <input class="change-role-student" type="radio" name="role" value="student"/>Student
            <input class="change-role-mentor" type="radio" name="role" value="mentor"/>Mentor
        </h4>
        <input class="save-button" name="savebutton" type="submit" value="Save"/>
    </form>
    <form action="/deletebutton" method="post">
        <input class="delete-password" type="password" id="delete" name="delete" placeholder="To delete your account give your password">
        <input class="delete-button" name="deletebutton" type="submit" value="Delete account"/>
        ${error}
    </form>
</div>
</body>
</html>