<%--
  Created by IntelliJ IDEA.
  User: Nikol
  Date: 10/25/2016
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connect</title>
</head>
<body>
    <form action="/connect" method="get">
        <table>
            <tr>
                <td>Server Url</td>
                <td><input name="server-name" type="text" value="localhost:5432"/></td>
            </tr>
            <tr>
                <td>User name</td>
                <td><input name="user-name" type="text" value="postgres"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input name="password" type="text" value="root"/></td>
            </tr>
            <td>
                <td><input type="submit" value="connect"></td>
                <td></td>
            </tr>
        </table>
    </form>
</body>
</html>
