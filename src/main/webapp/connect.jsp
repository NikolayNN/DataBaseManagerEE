<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
<form action="connectToServer" method="post">
    <table>
        <tr>
            <td>Server URL</td>
            <td><input type="text" name="serverurl" value="localhost:5432"/></td>
        </tr>
        <tr>
            <td>User name</td>
            <td><input type="text" name="username" value="postgres"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="root"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="connect"/></td>
        </tr>
    </table>
</form>
</body>
</html>