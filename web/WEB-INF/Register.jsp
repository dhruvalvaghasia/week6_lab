<%-- 
    Document   : Register
    Created on : 24 Feb, 2023, 4:26:57 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="shoppingList" method="post">
            Username:
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
