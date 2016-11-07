<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TableData</title>
</head>
<body>
    <c:forEach items="${tables}" var="table">
        <p>${table}</p>
    </c:forEach>
    <form method="post" action="/tabledata.do">
        <input type="text" name="selectedtable" />
    </form>
    ${table}
</body>
</html>
