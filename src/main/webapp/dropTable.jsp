<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DropTable</title>
</head>
<body>
<p>input table name for drop</p>
<c:forEach items="${tables}" var="table">
    <p>${table}</p>
</c:forEach>
<form method="post" action="/droptable.do">
    <input name="tableName" type="text" />
    <input type="submit" value="drop">
</form>
</body>
</html>
