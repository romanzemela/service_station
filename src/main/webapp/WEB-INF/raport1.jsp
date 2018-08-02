<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ajtus/roman
  Date: 02.08.18
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport1</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2 class="col-sm-11">Raport przepracowanych godzin: </h2>


    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Ilość przepracowanych godzin</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${raport1s}" var="raport1" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${raport1.firstName}</td>
                <td>${raport1.secondName}</td>
                <td>${raport1.iloscRoboczogodzin}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>
