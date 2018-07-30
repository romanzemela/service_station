<%--
  Created by IntelliJ IDEA.
  User: ajtus
  Date: 30.07.18
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj klienta</title>
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
            <li><a href="/">Naprawy</a></li>
            <li><a href="/employees">Pracownicy</a></li>
            <li class="active"><a href="/customers">Klienci</a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <h2>Edytowanie klienta:</h2>
    <form class="form-horizontal" action="#" method="post">
        <input type="number" hidden name="id" value="${customer.id}">
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">Imię:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="firstName" placeholder="Wpisz imię..." name="firstName" value="${customer.firstName}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="secondName">Nazwisko:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="secondName" placeholder="Wpisz nazwisko..." name="secondName" value="${customer.secondName}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="birthDay">Data urodzenia:</label>
            <div class="col-sm-2">
                <input type="date" class="form-control" id="birthDay" name="birthDay" value="${customer.birthday}">
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
