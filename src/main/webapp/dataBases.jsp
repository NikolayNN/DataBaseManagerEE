<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dataBases</title>
</head>
<body>
<c:forEach items="${databases}" var="database">
    <h1>${database}</h1>
</c:forEach>

</body>
</html>
