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
    <script>
        $(document).on("change", ".summand", function () {
            var employees = {
                <c:forEach items="${employees}" var="employee">
                ${employee.id}: {
                    price: ${employee.rate}
                },
                </c:forEach>
            }
            var parts = Number($("#partsCost").val());
            var workingHours = $("#workingHours").val();
            var employeeId = $("#employee").val();
            var hourCost = employees[employeeId].price;
            $("#totalCost").val(workingHours * hourCost + parts);
        });
    </script>
</head>
<body>


<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2>Edytowanie zlecenia:</h2>
    <form class="form-horizontal" action="#" method="post">
        <input type="number" hidden name="id" value="${order.id}">

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
                       value="${order.realRepairDate}">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="employee">Pracownik:</label>
            <div class="col-sm-4">
                <select class="form-control summand" id="employee" name="employee" required>
                    <c:forEach items="${employees}" var="employee" varStatus="loop">
                        <c:choose>
                            <c:when test="${employee.id == order.employee.id}">
                                <option value="${employee.id}" selected>${employee.name} ${employee.surname} - ${employee.rate} zł/h</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${employee.id}">${employee.name} ${employee.surname} - ${employee.rate} zł/h</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="problemDescription">Opis problemu:</label>
            <div class="col-sm-4">
                <textarea class="form-control" id="problemDescription" placeholder="Opis problemu..."
                          name="problemDescription"
                          rows="4" required>${order.problemDescription}</textarea>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="repairDescription">Opis naprawy:</label>
            <div class="col-sm-4">
                <textarea class="form-control" id="repairDescription" placeholder="Opis naprawy..."
                          name="repairDescription"
                          rows="4">${order.repairDescription}</textarea>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="status">Status:</label>
            <div class="col-sm-4">
                <select class="form-control" id="status" name="status">
                    <c:forEach items="${statuses}" var="status" varStatus="loop">
                        <c:choose>
                            <c:when test="${status.id == order.status.id}">
                                <option value="${status.id}" selected>${status.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${status.id}">${status.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="employee">Samochód:</label>
            <div class="col-sm-4">
                <select class="form-control" id="vehicle" name="vehicle" required>
                    <c:forEach items="${vehicles}" var="vehicle" varStatus="loop">
                        <c:choose>
                            <c:when test="${vehicle.id == order.vehicle.id}">
                                <option value="${vehicle.id}"
                                        selected>${vehicle.brand} ${vehicle.model} ${vehicle.plateNumber}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${vehicle.id}">${vehicle.brand} ${vehicle.model} ${vehicle.plateNumber}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="workingHours">Czas naprawy:</label>
            <div class="col-sm-4">
                <input type="number" class="form-control summand" id="workingHours" name="workingHours"
                       value="${order.workingHours}" step="0.1" min="0" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="partsCost">Koszt części:</label>
            <div class="col-sm-4">
                <input type="number" class="form-control summand" id="partsCost" name="partsCost"
                       value="${order.partsCost}" step="0.01" min="0" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="totalCost">Całkowity koszt:</label>
            <div class="col-sm-4">
                <input type="number" class="form-control" id="totalCost" name="totalCost"
                       value="${order.totalCost}" step="0.01" min="0" readonly required>
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
