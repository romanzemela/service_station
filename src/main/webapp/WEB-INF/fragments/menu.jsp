<%--
  Created by IntelliJ IDEA.
  User: ajtus
  Date: 30.07.18
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Service Station CRM</a>
        </div>
        <ul class="nav navbar-nav">
            <c:choose>
                <c:when test="${path == '/'}">
                    <li class="active"><a href="/">Naprawy</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/">Naprawy</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${path == '/employees'}">
                    <li class="active"><a href="/employees">Pracownicy</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/employees">Pracownicy</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${path == '/customers'}">
                    <li class="active"><a href="/customers">Klienci</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/customers">Klienci</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${path == '/vehicles'}">
                    <li class="active"><a href="/vehicles">Samochody</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/vehicles">Samochody</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${path == '/raports'}">
                    <li class="active"><a href="/raports">Raporty</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/raports">Raporty</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
        </ul>
    </div>
</nav>