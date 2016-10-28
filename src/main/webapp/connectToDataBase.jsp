<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
<c:forEach items="${dbnames}" var="dbname">
    <p>${dbname}</p>
</c:forEach>
<form action="connectToDataBase" method="post">
    <table>
        <tr>
            <td>Data Base name</td>
            <td><input type="text" name="dbname" required/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="connect"/></td>
        </tr>
    </table>
</form>
</body>
</html>