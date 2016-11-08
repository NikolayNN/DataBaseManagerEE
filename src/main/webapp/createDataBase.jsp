<%--
  Created by IntelliJ IDEA.
  User: Nikol
  Date: 11/8/2016
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateDataBase</title>
</head>
<body>
    <p>input database name</p>
    <form method="post" action="/createdb.do">
        <input type="text" name="dbname" />
        <input type="submit" value="create">
    </form>
</body>
</html>
