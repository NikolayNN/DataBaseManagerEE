<%--
  Created by IntelliJ IDEA.
  User: Nikol
  Date: 11/8/2016
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DropDatabase</title>
</head>
<body>
    <p>input database name for drop</p>
    <form method="post" action="/dropdb.do">
        <input name="dbname" type="text" />
        <input type="submit" value="drop">
    </form>
</body>
</html>
