<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQLCmd</title>
</head>
<body>
<h3>server url - ${serverUrl}</h3>
<h3>data base - ${dbName}</h3>
<c:forEach var="entry" items="${items}">
    <a href="${entry.value}">${entry.key}</a><br>
</c:forEach>
</body>
</html>