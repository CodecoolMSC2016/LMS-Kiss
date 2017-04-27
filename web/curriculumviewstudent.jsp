<!DOCTYPE html>
<html>
<title>Curriculum view</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="curriculumviewstudent.css">
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
        <div class="main">
            <h1>Curriculum</h1>
            <h3>Text page</h3>
            <input class="button" type="button" onclick="openWin('textcontent/java.txt')" value="Java" name="java"/><br/>
            <input class="button" type="button" onclick="openWin('textcontent/htmlcss.txt')" value="HTML/CSS" name="htmlcss"/><br/>
            <input class="button" type="button" onclick="openWin('textcontent/sql.txt')" value="SQL" name="sql"/>
            <input class="publish-button" type="submit" value="Publish"/><br/><br/>
            <h3>Assignments</h3>
            <input class="button" type="submit" onclick="openWin('assignment.jsp')" value="Java Assignment"/><br/>
            <a href="javascript:openWin('assignment.jsp')";></a>
        </div>
        <script>
            var myWindow;
            function  openWin(url) {
                myWindow = window.open(url, "myWindow", "width=400, height=300");
            }
        </script>
    </body>
</html>