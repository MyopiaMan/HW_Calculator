<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator start page</title>
</head>
<body>
<div align="center">
<h3><%= "Start page" %></h3>
<form method="post" action="/signIn">
    <table>
        <tr>
            <td><label for="loginID" class="form-label">Login</label></td>
            <td><input class="input" type="text" id="loginID" name="login" value="${login}" placeholder="Enter your login" /></td>
        </tr>
        <tr>
            <td><label for="passwordID" class="form-label">Password</label></td>
            <td><input class="input" type="text" id="passwordID" name="password" value="${password}" placeholder="Enter your password" /></td>
        </tr>
    </table>
    <input id="submit" type="submit" value="Log in">
</form>
<%--    <c:if test="${not empty errorMessage}">--%>
<%--        ${errorMessage}--%>
<%--    </c:if>--%>
<a href="signUp">Registration</a>

<br>${message}
</div>
</body>
</html>