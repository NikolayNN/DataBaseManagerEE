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
