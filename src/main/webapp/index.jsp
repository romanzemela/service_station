<%--
  Created by IntelliJ IDEA.
  User: ajtus
  Date: 29.07.18
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service Station</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="WEB-INF/fragments/menu.jsp"  %>

<div class="container">
    <h2>Aktualne naprawy: </h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Data przyjęcia<br>do naprawy</th>
            <th>Planowana data<br>rozpoczęcia naprawy</th>
            <th>Data rozpoczecia<br>naprawy</th>
            <th>Pracownik</th>
            <th>Status</th>
            <th>Koszt naprawy</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>14-12-2017</td>
            <td>12-06-2017</td>
            <td></td>
            <td>Janek</td>
            <td>Czeka</td>
            <td>200,00 zł</td>
            <td>
                <a href="#" role="button" class="btn btn-primary btn-sm m-0">Edytuj</a>
            </td>
            <td>
                <a href="#" role="button" class="btn btn-primary btn-sm m-0">Usuń</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<%@ include file="WEB-INF/fragments/footer.jsp"  %>

</body>
</html>
