<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pracownicy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp"  %>


 <div class="container">
    <h2 class="col-sm-11">Pracownicy: </h2>
    <div class="row">
        <div class="col-sm-11"></div>
        <a href="/employee/add" role="button" class="btn btn-primary btn-sm m-0 col-sm-1">Dodaj pracownika</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Telefon</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.phone}</td>
                <td>
                    <a href="/employees/details?id=${employee.id}" role="button" class="btn btn-primary btn-sm m-0">Szczegóły</a>
                </td>
                <td>
                    <a href="/?employeeId=${employee.id}" role="button" class="btn btn-primary btn-sm m-0">Zlecenia</a>
                </td>
                <td>
                    <a href="/employees/edit?id=${employee.id}" role="button" class="btn btn-primary btn-sm m-0">Edytuj</a>
                </td>
                <td>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-sm m-0" data-toggle="modal" data-target="#usun${employee.id}">
                        Usuń
                    </button>

                    <!-- Modal -->
                    <div class="modal fade bd-example-modal-sm" id="usun${employee.id}" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-sm role="document">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Czy na pewno chcesz usunąć?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary btn-sm m-0" data-dismiss="modal">Nie</button>
                                    <a href="/employees/delete?id=${employee.id}" role="button" class="btn btn-primary btn-sm m-0">Tak</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
 </div>

 <%@ include file="fragments/footer.jsp" %>

</body>
</html>
