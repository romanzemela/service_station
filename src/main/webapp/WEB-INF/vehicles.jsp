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

    <form class="form-horizontal" action="/vehicles" method="get">
        <div class="form-group col-sm-10">
            <label class="control-label col-sm-1" for="customer">Klient:</label>
            <div class="col-sm-3">
                <select class="form-control" id="customer" name="customerId" onchange="this.form.submit()">
                    <option value=null>Wybierz klienta</option>
                    <c:forEach items="${customers}" var="customer" varStatus="loop">
                        <c:choose>
                            <c:when test="${customer.id == customerId}">
                                <option value="${customer.id}" selected>${customer.firstName} ${customer.secondName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customer.id}">${customer.firstName} ${customer.secondName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-sm-2">
            <c:choose>
                <c:when test="${customerId != null}">
                    <a href="/vehicles/add?customerId=${customerId}" role="button" class="btn btn-primary btn-sm m-0 btn-block">Dodaj Pojazd</a>
                </c:when>
                <c:otherwise>
                    <a href="/vehicles/add" role="button" class="btn btn-primary btn-sm m-0 btn-block">Dodaj Pojazd</a>
                </c:otherwise>
            </c:choose>
        </div>
    </form>



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
