
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.LOGIN_ERROR}
        <form action="MainController" method="POST">
            <input placeholder="Username" type="text" name="txtUserID" value=""/> <br/>
            <input placeholder="Password" type="password" name="txtPassword" value=""/> <br/>
            <input type="submit" value="Login" name="btnAction"/>
        </form>
    </body>
</html>
