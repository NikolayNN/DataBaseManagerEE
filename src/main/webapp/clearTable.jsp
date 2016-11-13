<%--
  Created by IntelliJ IDEA.
  User: Nikol
  Date: 11/11/2016
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>clearTable</title>
</head>
<body>
    <p>input table name</p>
    <form method="post" action="/cleartable.do">
        <input type="text" name="name"/>
        <input type="submit" value="clear"/>
    </form>

</body>
</html>
