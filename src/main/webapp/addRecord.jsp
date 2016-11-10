<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addRecord</title>
</head>
<body>
    <p>input table name</p>
    <form method="post" action="/gettableheaders.do">
        <input type="text" name="tableName" />
        <input type="submit" value="next">
    </form>
    <table>
        <tr>
            <c:forEach items="${columnHeaders}" var="columnHeader">
                <th>${columnHeader}</th>
            </c:forEach>
        </tr>
        <form name="addRecordForm" method="get" action="/addrecord.do">
            <input type="hidden" name="tableName" value="${inputedTableName}">
            <tr>
                <c:forEach items="${columnNames}" var="columnName">
                    <td>
                        <input name=${columnName} type="text"/>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="add">
                </td>
            </tr>
        </form>
    </table>
</body>
</html>
