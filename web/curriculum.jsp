
<!DOCTYPE html>
<html>
<title>Curriculum view</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="curriculum/demo.css" type="text/css">
<link rel="stylesheet" href="curriculum/w3.css" type="text/css">


<script type="text/javascript" src="curriculum/jquery.min.js"></script>
<script type="text/javascript" src="curriculum/highlight.pack.js"></script>
<script type="text/javascript" src="curriculum/jquery.cookie.js"></script>
<script type="text/javascript" src="curriculum/jquery.collapsible.js"></script>

<style>
    body {
        background-image: url("wall.jpg");
    }
    body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
    .w3-row-padding img {margin-bottom: 12px}
    /* Set the width of the sidebar to 120px */
    .w3-sidebar {width: 120px;background: #222;}
    /* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
    #main {margin-left: 120px}
    /* Remove margins from "page content" on small screens */
    @media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>
<body class="w3-black">
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
    <a href="curriculum.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-file-text-o w3-xxlarge"></i>
        <p>CURR. VIEW</p>
    </a>
    <a href="index.html" class="w3-bar-item w3-button w3-padding-large w3-hover-black" name="button4">
        <i class="fa fa-power-off w3-xxlarge"></i>
        <p>LOG OUT</p>
    </a>>
</nav>

<div id = curr class="position">
<div id ="getrole" hidden="hidden"><input type="text" value = "", id="role"><input type ="text" value="" id="nextid"></div>
<div id="content">

    <a href="#" id="closeAll" title="Close all">Open All</a> | <a href="#" id="openAll" title="Open All">Close All</a>

</div>

<script type="text/javascript">
    $(document).ready(function() {

        $.get("/updateCurriculum", function (data) {
            console.log(data);
            var getrole = document.getElementById("role");
            getrole.value = data;

        })

        $.get("/curriculum", function (data) {
            //console.log("Data: ", data);
            var nextid = document.getElementById("nextid");
            nextid.value = data.length;
            nextid.value ++;
            $.each(data, function (index, element) {
                var role = document.getElementById("role");

                var ispublished = element.isPublished;

                console.log("Role: " + role.value);

                if (role.value == '"mentor"'){
                    if(ispublished == '0'){
                        $('#content').append("<div class=\"page_collapsible collapse-open collapse-close\" id=\"body-section\">" + element.title +
                            "(not published yet)<span></span></div><div class=\"container\" style=\"display: none;\">" +
                            "<div class=\"content\" <p><i> Type: "+ element.contenttype + "</i></p></div>" +
                            "<div class=\"content\" id =\"content" + element.id + "\" contenteditable='true' ><p>" +
                            element.content + "</p><br></div><div class = \"content\" id='\buttons\'>"+
                            "<form action =\"/publishButton\" method = \"post\"><input type =\"submit\" value =\"Publish\">" +
                            "<input name =\"id\" type =\"text\" hidden = \"hidden\" value =\"" + element.id + "\">" +
                            "<input type='submit' value='Edit' hidden='hidden'>" +
                            "<input name = \"data\" id=\"data" + element.id + "\" type =\"textarea\" hidden = \"hidden\" value = \"\"></form>" +
                            "<button id =\"save\" onclick=\"getEdit(this, 'content" + element.id + "', " + "'data" + element.id + "');\">Save</button>"+
                            "</div></div>");
                    }
                    else {
                        $('#content').append("<div class=\"page_collapsible collapse-open collapse-close\" id=\"body-section\">" + element.title +
                            "<span></span></div><div class=\"container\" style=\"display: none;\">" +
                            "<div class=\"content\" <p><i> Type: "+ element.contenttype + "</i></p></div>" +
                            "<div class=\"content\" id =\"content" + element.id + "\" contenteditable='true' ><p>" +
                            element.content + "</p><br></div><div class = \"content\" id='\buttons\'>"+
                            "<form action =\"/publishButton\" method = \"post\"><input type =\"submit\" value =\"Publish\">" +
                            "<input name =\"id\" type =\"text\" hidden = \"hidden\" value =\"" + element.id + "\">" +
                            "<input type='submit' value='Edit' hidden='hidden'>" +
                            "<input name = \"data\" id=\"data" + element.id + "\" type =\"textarea\" hidden = \"hidden\" value = \"\"></form>" +
                            "<button id =\"save\" onclick=\"getEdit(this, 'content" + element.id + "', " + "'data" + element.id + "');\">Save</button>"+
                            "</div></div>");
                    }

                }
                else {
                    if(ispublished =='1'){
                        $('#content').append("<div class=\"page_collapsible collapse-close\" id=\"body-section\">" + element.title +
                            "<span></span></div><div class=\"container\" style=\"display: none;\">"+
                            "<div class=\"content\" <p><i> Type: "+ element.contenttype + "</i></p></div>" +
                            "<div class=\"content\"><p>" +element.content + "</p></div></div>");
                    }

                }



                console.log(element.title);


            })
            if(role.value == '"mentor"') {
                $('#content').append("<div class=\"page_collapsible collapse-open collapse-close\" id=\"body-section\">Add new content" +
                    "<span></span></div><div class=\"container\" style=\"display: none;\">" +
                    "<form action =\"/addContent\" method = \"post\">" +
                    "<div class=\"content\" <p><i> Type: </i>" +
                    "<input name=\"type\" type=\"radio\" checked = \"checked\" value=\"text\" /> text<input name=\"type\" type=\"radio\" value=\"assignment\"/>assigment</p>" +
                    "<p><i>Title :</i><input name = \"title\" type=\'text\' value=''></p>" +
                    "<input type =\"text\" hidden = \"hidden\" name=\"newid\" value =\"" + nextid.value + "\">" +
                    "<input type =\"submit\" value = \"Add content\"></form></div>" +
                    "</form></div></div>");
            }



//syntax highlighter
            hljs.tabReplace = '    ';
            hljs.initHighlightingOnLoad();

            $.fn.slideFadeToggle = function (speed, easing, callback) {
                return this.animate({opacity: 'toggle', height: 'toggle'}, speed, easing, callback);
            };

            //collapsible management

            $('.page_collapsible').collapsible({
                defaultOpen: 'body_section',
                cookieName: 'body2',
                speed: 'slow',
                animateOpen: function (elem, opts) { //replace the standard slideUp with custom function
                    elem.next().slideFadeToggle(opts.speed);
                },
                animateClose: function (elem, opts) { //replace the standard slideDown with custom function
                    elem.next().slideFadeToggle(opts.speed);
                },
                loadOpen: function (elem) { //replace the standard open state with custom function
                    elem.next().show();
                },
                loadClose: function (elem, opts) { //replace the close state with custom function
                    elem.next().hide();
                }

            });
        })

        //assign open/close all to functions
        function openAll() {
            $('.page_collapsible').collapsible('openAll');
        }

        function closeAll() {
            $('.page_collapsible').collapsible('closeAll');
        }

        //listen for close/open all
        $('#closeAll').click(function (event) {
            event.preventDefault();
            closeAll();

        });
        $('#openAll').click(function (event) {
            event.preventDefault();
            openAll();
        });

    });
</script>
<script type="text/javascript">
    function getEdit(button, id, data) {
        var x = document.getElementById(id);
        var d = document.getElementById(data);
        if (x.contentEditable == "true") {
            x.contentEditable = "false";
            button.innerHTML = "Edit";
            d.value = document.getElementById(id).innerHTML;
        } else {
            x.contentEditable = "true";
            button.innerHTML = "Save";
            console.log(document.getElementById(id).innerHTML);
            console.log(document.getElementById(data).value);

        }
    }
</script>
</div>
</body>
</html>