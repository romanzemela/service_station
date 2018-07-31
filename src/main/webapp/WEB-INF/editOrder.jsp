<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edytuj zlecenie</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Service Station CRM</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Naprawy</a></li>
            <li><a href="/employees">Pracownicy</a></li>
            <li><a href="/customers">Klienci</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Edytowanie zlecenia:</h2>
    <form class="form-horizontal" action="#" method="post">
        <input type="number" hidden name="id" value="${employee.id}">
        <div class="form-group">
            <label class="control-label col-sm-2" for="arrivalDate">Data przyjęcia:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="arrivalDate" name="arrivalDate" value="${order.arrivalDate}"
                       required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="plannedRepairDate">Planowana data naprawy:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="plannedRepairDate" name="plannedRepairDate"
                       value="${order.plannedRepairDate}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="realRepairDate">Rzeczywista data naprawy:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="realRepairDate" name="realRepairDate"
                       value="${order.realRepairDate}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="employee">Pracownik:</label>
            <div class="col-sm-4">
                <select class="form-control" id="employee">
                    <c:forEach items="${employees}" var="employee" varStatus="loop">
                        <c:choose>
                            <c:when test="${employee == order.employee}">
                                <option value="${employee}" selected>${employee.name} ${employee.surname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${employee}">${employee.name} ${employee.surname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="phone">Telefon:</label>
            <div class="col-sm-4">
                <input type="number" min="0" class="form-control" id="phone" placeholder="Wpisz telefon..." name="phone"
                       value="${employee.phone}" required>
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
