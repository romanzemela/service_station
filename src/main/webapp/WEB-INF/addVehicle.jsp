<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dodaj pojazd</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2>Dodawanie pojazdu:</h2>
    <form class="form-horizontal" action="#" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="model">Model:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="model" name="model" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="brand">Marka:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="brand" name="brand" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="productionYear">Rok produkcji:</label>
            <div class="col-sm-4">
                <input type="number" class="form-control" id="productionYear" name="productionYear"
                       step="1" min="1800" max="${year}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="plateNumber">Tablica rejestracyjna:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="plateNumber" name="plateNumber" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="nextInspectionDate">Data następnej inspekcji:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="nextInspectionDate" name="nextInspectionDate"
                       required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="customer">Klient:</label>
            <div class="col-sm-4">
                <select class="form-control" id="customer" name="customer" required>
                    <option selected disabled hidden style='display: none' value="">Wybierz klienta</option>
                    <c:forEach items="${customers}" var="customer" varStatus="loop">
                        <c:choose>
                            <c:when test="${customer.id == customerId}">
                                <option value="${customer.id}"
                                        selected>${customer.firstName} ${customer.secondName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customer.id}">${customer.firstName} ${customer.secondName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Zapisz</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>
