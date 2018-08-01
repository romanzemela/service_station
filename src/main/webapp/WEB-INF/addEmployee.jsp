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
    <h2>Dodawanie pracownika:</h2>
    <form class="form-horizontal" action="#" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Imię:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="name" placeholder="Wpisz imię..." name="name" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="surname">Nazwisko:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="surname" placeholder="Wpisz nazwisko..." name="surname" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="address">Adres:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="address" placeholder="Wpisz adres..." name="address" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="phone">Telefon:</label>
            <div class="col-sm-4">
                <input type="number" class="form-control" min="0" id="phone" placeholder="Wpisz telefon..." name="phone" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="note">Uwagi:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="note" placeholder="Wpisz uwagi..." name="note" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="rate">Stawka godzinowa:</label>
            <div class="col-sm-4">
                <input type="number" min="0.00" step="0.01" class="form-control" id="rate" placeholder="Wpisz stawkę..." name="rate" required>
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
