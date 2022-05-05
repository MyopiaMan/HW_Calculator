<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 26.04.2022
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator page</title>
</head>
<body>
    <form action="/calc" method="post">
        <input type="number" name="num1" placeholder="Enter number 1"/>
        <input type="number" name="num2" placeholder="Enter number 2"/>
        <select name="operation">
            <option value="sum">+ (SUM)</option>
            <option value="diff">- (DIFFERENCE)</option>
            <option value="mult">* (MULTIPLICATION)</option>
            <option value="div">/ (DIVISION)</option>
        </select>
<%--        <input type="text" name="operation" placeholder="enter operation"/>--%>
        <button>Submit</button>
        <p>Calculation result: <output>${requestScope.result}</output></p>
<%--        <a href="signIn">Back</a>--%>
        <a href="logout">Logout</a>
    </form>
<%--    <p>${requestScope.result}</p>--%>
</body>
</html>
