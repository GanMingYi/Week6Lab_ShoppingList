<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body style="background-color: #121212; color: limegreen">
        <div style="text-align: left; margin-top: 10rem; margin-left: 40%; font-size: 1vw">
            <h1>Shopping List</h1>
            Hello, ${username} <a href="<c:url value='ShoppingList?action=logout'/>">Logout</a>
            <h2>List</h2>
            <form action="ShoppingList?action=add" method="post">
                Add Item: <input type="text" name="item"><input type="submit" value="Add">
            </form>
            <form action="ShoppingList?action=delete" method="post">
                <c:if test="${shoppingList != null}">
                    <c:forEach items="${shoppingList}" var="item">
                        <li>
                            <input type="radio" name="items" value="${item}">${item}</br>
                        </li>
                    </c:forEach>
                </c:if>
                        <input type="submit" value="Delete">
            </form>
            ${message}
        </div>
    </body>
</html>
