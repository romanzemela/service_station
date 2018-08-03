<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj pojazd</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp" %>

<div class="container">
    <h2>Edytowanie pojazdu:</h2>

    <form class="form-horizontal" action="#" method="post">
        <input type="number" hidden name="id" value="${vehicle.id}">

        <div class="form-group">
            <label class="control-label col-sm-2" for="model">model:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="model" placeholder="Wpisz model..." name="model"
                       value="${vehicle.model}" pattern="^[a-zA-Z]{3,}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="brand">Marka:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="brand" placeholder="Wpisz markę..." name="brand"
                       value="${vehicle.brand}" pattern="^[a-zA-Z]{3,}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="productionYear">Rok produkcji:</label>
            <div class="col-sm-2">
                <input type="number" min="1800" max="${maxYear}" step="1" class="form-control"
                       placeholder="Wpisz rok produkcji..." id="productionYear" name="productionYear"
                       value="${vehicle.productionYear}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="plateNumber">Tablica Rejestracyjna:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="plateNumber" placeholder="Wpisz znaki z tablicy..."
                       name="plateNumber" value="${vehicle.plateNumber}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="nextInspectionDate">Data następnej inspekcji:</label>
            <div class="col-sm-2">
                <input type="date" class="form-control" id="nextInspectionDate" name="nextInspectionDate"
                       value="${vehicle.nextInspectionDate}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="customer">Klient</label>
            <div class="col-sm-2">
                <select class="form-control" id="customer" name="customer">
                    <c:forEach items="${customers}" var="customer" varStatus="loop">
                        <c:choose>
                            <c:when test="${customer.id == vehicle.customer.id}">
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
