<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ajtus
  Date: 30.07.18
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Klienci</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2 class="col-sm-11">Klienci: </h2>
    <div class="row">
        <div class="col-sm-11"></div>
        <a href="/customers/add" role="button" class="btn btn-primary btn-sm m-0 col-sm-1">Dodaj klienta</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Data urodzenia</th>
            <th class="col-sm-1">Pojazdy</th>
            <th class="col-sm-1"></th>
            <th class="col-sm-1"></th>
            <th class="col-sm-1"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${customer.firstName}</td>
                <td>${customer.secondName}</td>
                <td>${customer.birthday}</td>


                <td><a href="/vehicles?customerId=${customer.id}" class="btn btn-primary btn-sm m-0 btn-block">sam</a>
                </td>
                <td></td>

                <td>
                    <a href="/customers/edit?id=${customer.id}" role="button"
                       class="btn btn-primary btn-sm m- btn-block">Edytuj</a>
                </td>
                <td>
                    <a href="/customers/delete?id=${customer.id}" role="button"
                       class="btn btn-primary btn-sm m-0 btn-block">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>
