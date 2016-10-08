<%--
  Created by IntelliJ IDEA.
  User: Nikol
  Date: 10/8/2016
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
  <li>
    <p>connect-server</p>
    <p>Connect to a server 'connect-server|serverUrl|login|password</p>
  </li>

  <li>
    <p>connect-db</p>
    <p>Connect to database 'connect-db|dbname'</p>
  </li>

  <li>
    <p>disconnect-db</p>
    <p>disonnect current database 'disconnect-db'</p>
  </li>

  <li>
    <p>list-db</p>
    <p>Show available data bases in the current server 'list-db'</p>
  </li>
  <li>
    <p>current-db</p>
    <p>Show current data base name 'current-db'</p>
  </li>
  <li>
    <p>drop-db</p>
    <p>Delete the data base 'drop-db|dataBaseName'</p>
  </li>

  <li>
    <p>create-db</p>
    <p>Create new data base 'create-db|dataBaseName'</p>
  </li>

  <li>
    <p>create-table</p>
    <p>Create new table in the current data base 'create-table|tableName'</p>
  </li>

  <li>
    <p>drop-table</p>
    <p>Drop table 'drop-table|tableName'</p>
  </li>

  <li>
    <p>table-list</p>
    <p>Show exist tables in the current database 'table-list'</p>
  </li>

  <li>
    <p>table-data</p>
    <p>Show all table rows 'table-data|tableName'</p>
  </li>

  <li>
    <p>table-data-where</p>
    <p>Show table rows with the condition WHERE 'table-data-where|tableName'</p>
  </li>

 <li>
    <p>add-record</p>
    <p>Add record in the selected table 'add-record|tableName'</p>
  </li>

 <li>
    <p>update-table</p>
    <p>Update record in the selected table 'update-table|tableName</p>
  </li>

 <li>
    <p>clear-table</p>
    <p>Clear selected table 'clear-table|tableName'</p>
  </li>

 <li>
    <p>exit</p>
    <p>Close connection to a database and exit</p>
  </li>
</ul>
</body>
</html>
