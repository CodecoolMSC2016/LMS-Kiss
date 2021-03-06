<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Login</title>



    <style>

        body{
            margin: 0;
            padding: 0;
            background: #fff;

            color: #fff;
            font-family: Arial;
            font-size: 12px;
        }

        .body{
            position: absolute;
            top: -20px;
            left: -20px;
            right: -40px;
            bottom: -40px;
            width: auto;
            height: auto;
            background-image: url(https://newevolutiondesigns.com/images/freebies/city-wallpaper-18.jpg);
            background-size: cover;
            -webkit-filter: blur(5px);
            z-index: 0;
        }

        .grad{
            position: absolute;
            top: -20px;
            left: -20px;
            right: -40px;
            bottom: -40px;
            width: auto;
            height: auto;
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
            z-index: 1;
            opacity: 0.7;
        }

        .header{
            position: absolute;
            top: calc(50% - 35px);
            left: calc(50% - 255px);
            z-index: 2;
        }

        .header div{
            float: left;
            color: #fff;
            font-family: 'Exo', sans-serif;
            font-size: 35px;
            font-weight: 200;
        }

        .header div span{
            color: #5379fa !important;
        }

        .login{
            position: absolute;
            top: calc(50% - 75px);
            left: calc(50% - 50px);
            height: 150px;
            width: 350px;
            padding: 10px;
            z-index: 2;

        }

        .login input[type=email]{
            width: 300px;
            -moz-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            -webkit-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            box-shadow:inset 0px 0px 15px 3px #91b8b3;
            background-color:transparent;
            -moz-border-radius:17px;
            -webkit-border-radius:17px;
            border-radius:17px;
            border:1px solid #566963;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-size:15px;
            padding:6px 13px;
            text-decoration:none;
            text-shadow:0px 1px 0px #2b665e;
        }

        .login input[type=password]{
            width: 300px;
            -moz-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            -webkit-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            box-shadow:inset 0px 0px 15px 3px #91b8b3;
            background-color:transparent;
            -moz-border-radius:17px;
            -webkit-border-radius:17px;
            border-radius:17px;
            border:1px solid #566963;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-size:15px;
            padding:6px 13px;
            text-decoration:none;
            text-shadow:0px 1px 0px #2b665e;
        }
        .login input[type=submit]{
            align-items: center;
            width: 328px;
            -moz-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            -webkit-box-shadow:inset 0px 0px 15px 3px #91b8b3;
            box-shadow:inset 0px 0px 15px 3px #91b8b3;
            background-color:transparent;
            -moz-border-radius:17px;
            -webkit-border-radius:17px;
            border-radius:17px;
            border:1px solid #566963;
            display:inline-block;
            cursor:pointer;
            color:#ffffff;
            font-size:15px;
            padding:6px 13px;
            text-decoration:none;
            text-shadow:0px 1px 0px #2b665e;

        .login input[type=button]{
            width: 260px;
            height: 35px;
            background: #fff;
            border: 1px solid #fff;
            cursor: pointer;
            border-radius: 2px;
            color: #a18d6c;
            font-family: 'Exo', sans-serif;
            font-size: 16px;
            font-weight: 400;
            padding: 6px;
            margin-top: 10px;
        }

        .login input[type=submit]:hover{
            opacity: 0.8;
            border: dotted;
            border-color: chartreuse;
        }
        .login input[type=email]:hover{
            opacity: 0.8;
            border: dotted;
            border-color: chartreuse;
        }
        .login input[type=password]:hover{
            opacity: 0.8;
            border: dotted;
            border-color: chartreuse;
        }

        .login input[type=button]:active{
            opacity: 0.6;
        }

        .login input[type=email]:focus{
            outline: none;
            border: 1px solid rgba(255,255,255,0.9);
        }

        .login input[type=password]:focus{
            outline: none;
            border: 1px solid rgba(255,255,255,0.9);
        }

        .login input[type=button]:focus{
            outline: none;
        }

        ::-webkit-input-placeholder{
            color: rgba(255,255,255,0.6);
        }
        h5 {
            position: relative;

        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>LMS<span>KISS</span></div>
</div>
<br>
<div class="login">
    <form action="/login" method="post" >
        <p><input type="email" placeholder="Email" name="email"></p>
        <p><input type="password" placeholder="Password" name="pw"><p><br>
        <input type="submit" value="Login">
        <h5>${message}</h5>
    </form>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>
