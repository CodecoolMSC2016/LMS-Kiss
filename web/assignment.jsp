<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="assignment.css">
    <meta charset="UTF-8">
    <%@page pageEncoding="UTF-8"%>
    <title>Assigments</title>
</head>
<body>
<form action="assignment" method="POST">
    <div class="main">
    <h4>1. What is HTML?</h4>
        <input type="radio" name="q1" value="a"/>Hypertext Library<br/>
        <input type="radio" name="q1" value="b"/>Scripting Language<br/>
        <input type="radio" name="q1" value="c"/>Markup Language<br/>
        <input type="radio" name="q1" value="d"/>Programming Language<br/>
        <h4>2. What's CSS stands for?</h4>
        <input type="radio" name="q2" value="a"/>Cascading Style Sheets<br/>
        <input type="radio" name="q2" value="b"/>Colorful Shape Seprű<br/>
        <input type="radio" name="q2" value="c"/>15<br/>
        <input type="radio" name="q2" value="d"/>Kascading Style Sítsz<br/>
        <h4>3. What is the extension of Java source files?</h4>
        <input type="radio" name="q3" value="a"/>.txt<br/>
        <input type="radio" name="q3" value="b"/>.klassz<br/>
        <input type="radio" name="q3" value="c"/>.java<br/>
        <input type="radio" name="q3" value="d"/>.teve/pata<br/>
        <h4>4. Single-line comments are created using:</h4>
        <input type="radio" name="q4" value="a"/>*/ characters at the begenning of the line<br/>
        <input type="radio" name="q4" value="b"/>// characters at the end of the line<br/>
        <input type="radio" name="q4" value="c"/>** characters at the begenning of the line<br/>
        <input type="radio" name="q4" value="d"/>// characters at the begenning of the line<br/>
        <h4>5. "5" + "5"?</h4>
        <input type="radio" name="q5" value="a"/>"10"<br/>
        <input type="radio" name="q5" value="b"/>"55"<br/>
        <input type="radio" name="q5" value="c"/>10<br/>
        <input type="radio" name="q5" value="d"/>Majomkenyérfa<br/><br/>
        <input class="submit-button" type="submit" name="submit" onclick=hideButton() value="Submit"/></br>
        ${error}
    </div>
</form>
</body>
</html>