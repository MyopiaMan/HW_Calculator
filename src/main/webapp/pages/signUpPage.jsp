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
    <title>Registration page</title>
</head>
<body>
<div align="center">
<h3><%= "Registration page" %></h3>
<form method="post" action="/signUp">
        <table>
            <tr>
                <td><label for="usernameReg" class="form-label">User name:</label></td>
                <td><input type="text" id="usernameReg" name="username" pattern=".{3,}" placeholder="Enter your name" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><h6>(minimum three characters)</h6></td>
            </tr>
            <tr>
                <td><label for="loginReg" class="form-label">Login</label></td>
                <td><input type="text" id="loginReg" name="login" pattern=".{3,}" placeholder="Enter your login" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><h6>(minimum three characters)</h6></td>
            </tr>
            <tr>
                <td><label for="passwordReg" class="form-label">Password</label></td>
                <td><input type="text" id="passwordReg" name="password" pattern=".{6,}" placeholder="Enter your password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><h6>(minimum six characters)</h6></td>
            </tr>
        </table>

<%--    User name:--%>
<%--    <input type="text" name="username" pattern=".{3,}" placeholder="Enter your name"><br>--%>
<%--    Login:--%>
<%--    <input type="text" name="login" pattern=".{3,}" placeholder="Enter your login"><br>--%>
<%--    Password:--%>
<%--    <input type="text" name="password" placeholder="Enter your password"><br>--%>
    <input type="submit" value="Sign Up">
</form>
</div>
</body>
</html>
