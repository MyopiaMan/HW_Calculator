<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 01.05.2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Welcome to User page</h1>
        <b>Hello, ${user.username} !</b>
        <br><br>
        <a href="pages/calc.jsp">Calculator</a>
        <a href="logout">Logout</a>
    </div>
</body>
</html>
