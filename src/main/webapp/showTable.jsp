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

    <form method="post" action="/showtable.do">
        <input type="text" name="selectedtable"/>
        <input type="submit" value="show">
    </form>
    <h2>${table.name}</h2>
    <table>
        <tr>
            <c:forEach items="${table.headerRow.headerCells}" var="headerCell">
                <th>${headerCell}</th>
            </c:forEach>
        </tr>
            <c:forEach items="${table.rows}" var="row">
                <tr>
                    <c:forEach items="${row.cells}" var="cell">
                        <td>${cell.value}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
