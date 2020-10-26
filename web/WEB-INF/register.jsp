<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Registration</title>
    </head>
    <body style="background-color: #121212; color: aliceblue">
        <div style="text-align: left; margin-top: 10rem; margin-left: 40%; font-size: 1vw">
            <h1>Shopping List</h1>
            <form action="ShoppingList?action=register" method="post">
                Username: <input type="text" name="username">
                <input type="submit" value="Register name">
            </form>
            ${message}
        </div>
    </body>
</html>
