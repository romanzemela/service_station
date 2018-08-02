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
    <title>Raporty</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/fragments/menu.jsp" %>


<div class="container">
    <h2 class="col-sm-11">Raporty: </h2>

    <table class="table table-striped">
        <thead>
        <tr>

            <th>Raport</th>
            <th class="col-sm-1"></th>
        <tr>
            <td>Raport przepracowanych godzin</td>
            <td><a href="/raport1" role="button"
                   class="btn btn-primary btn-sm m-0 btn-block">Raport 1</a></td>
        </tr>
        <tr>
            <td>Uproszczony raport zysków</td>
            <td><a href="/raport2" role="button"
                   class="btn btn-primary btn-sm m-0 btn-block">Raport 2</a></td>
        </tr>

        </tbody>
    </table>
</div>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>
