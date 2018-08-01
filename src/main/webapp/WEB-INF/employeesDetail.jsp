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
    <h2>Dane szczegółowe pracownika:</h2>
    <table class="table table-striped">
        <tr>
            <th scope="row">Id</th>
            <td>${employee.id}</td>
        </tr>
        <tr>
            <th scope="row">Imię</th>
            <td>${employee.name}</td>
        </tr>
        <tr>
            <th scope="row">Nazwisko</th>
            <td>${employee.surname}</td>
        </tr>
        <tr>
            <th scope="row">Adres</th>
            <td>${employee.address}</td>
        </tr>
        <tr>
            <th scope="row">Telefon</th>
            <td>${employee.phone}</td>
        </tr>
        <tr>
            <th scope="row">Uwagi</th>
            <td>${employee.note}</td>
        </tr>
        <tr>
            <th scope="row">Stawka godzinowa</th>
            <td>${employee.rate}</td>
        </tr>
    </table>
 </div>

 <%@ include file="fragments/footer.jsp" %>

</body>
</html>
