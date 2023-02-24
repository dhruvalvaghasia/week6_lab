<%-- 
    Document   : ShoppingList
    Created on : 24 Feb, 2023, 4:26:42 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppingList</title>
    </head>
      <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        <form action="" method="post">
            Add item:
            <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="post">
            <ul>
                <c:forEach var="add_list" items="${list}">
                    <li>
                        <input type="radio" name="item" value="${add_list}">${add_list}
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>

    </body>
</html>
