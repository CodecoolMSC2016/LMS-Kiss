/**
 * Created by sziszka on 2017.04.11..
 */
<html>
    <head>
        <title>Curriculum view</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="curriculumviewstudent.css">
    </head>
    <body>
        <div class="main">
            <h1>Curriculum</h1>
            <h3>Text page</h3>
            <input class="button" type="button" onclick="openWin('java.txt')" value="Java" name="java"/><br/>
            <input class="button" type="button" onclick="openWin('htmlcss.txt')" value="HTML/CSS" name="htmlcss"/><br/>
            <input class="button" type="button" onclick="openWin('sql.txt')" value="SQL" name="sql"/><br/>
            <input class="publish-button" type="submit" value="Publish"/><br/><br/>
            <h3>Assignments</h3>
            <input class="button" type="submit" onclick="openWin('assigment.html')" value="Java Assignment"/><br/>
            <a href="javascript:openWin('assigment.html')";></a>
        </div>
        <script>
            var myWindow;
            function  openWin(url) {
                myWindow = window.open(url, "myWindow", "width=400, height=300");
            }
        </script>
    </body>
</html>