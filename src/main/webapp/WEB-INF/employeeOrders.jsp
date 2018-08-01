<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%@ include file="/WEB-INF/fragments/menu.jsp"  %>

<div class="container">
    <h2>Aktualne naprawy dla pracownika:</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Data przyjęcia<br>do naprawy</th>
            <th>Planowana data<br>rozpoczęcia naprawy</th>
            <th>Data rozpoczecia<br>naprawy</th>
            <th>Opis problemu</th>
            <th>Nr rejestrcyjny pojazdu</th>
            <th>Przepracowane godziny</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${order.arrivalDate}</td>
                <td>${order.plannedRepairDate}</td>
                <td>${order.realRepairDate}</td>
                <td>${order.problemDescription}</td>
                <td>${order.vehicle.plateNumber}</td>
                <td>${order.workingHours}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/fragments/footer.jsp"  %>

</body>
</html>
