<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 31.07.18
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pojazdy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2 class="col-sm-11">Pojazdy: </h2>
    <div class="row">
        <div class="col-sm-11"></div>
        <a href="/vehicles/add" role="button" class="btn btn-primary btn-sm m-0 col-sm-1">Dodaj Pojazd</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Model</th>
            <th>Marka</th>
            <th>Rok Produkcji</th>
            <th>Tablica Rejestracyjna</th>
            <th>Następny Przegląd</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehicles}" var="vehicle" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.brand}</td>
                <td>${vehicle.productionYear}</td>
                <td>${vehicle.plateNumber}</td>
                <td>${vehicle.nextInspectionDate}</td>
                <td>
                    <a href="/vehicles/edit?id=${vehicle.id}" role="button"
                       class="btn btn-primary btn-sm m-0">Edytuj</a>
                </td>
                <td>
                    <a href="/vehicles/delete?id=${vehicle.id}" role="button"
                       class="btn btn-primary btn-sm m-0">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>
