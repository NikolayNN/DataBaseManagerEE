<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tables</title>
</head>
<body>
    <c:forEach items="${tables}" var="table">
        <p>${table}</p>
    </c:forEach>
</body>
</html>
