<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>База автомобилей</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body class="fon" style="background-image: url('././resources/img/1.jpg');">
<header>
    <nav>
        <ul>
            <li><a href="${contextPath}/">Главная</a> </li>
            <li> <a href="${contextPath}/bazaavto">База автомобилей</a> </li>
            <li><a href="${contextPath}/resources/Pravila.html">Правила</a></li>
            <li><a href="${contextPath}/resources/kontakt.html">Контакты</a> </li>
            <li> <a href="${contextPath}/registration">Регистрация</a> </li>
            <li> <a href="${contextPath}/login">Войти</a> </li>
        </ul>
    </nav>
</header>

<div class="block3">
    <c:forEach var="x" items="${cars}">
        <div class="bazaavtoCar">
            <table>
                <tr><td colspan="2">${x.marka} ${x.model}</td></tr>
                <tr><td colspan="2"><img src="${x.img}" alt=${x.model} height="200" width="300" border="1"></td></tr>
                <tr> <td>Имя</td><td>${x.name}</td></tr>
                <tr> <td>Трансмиссия</td><td>${x.transmission}</td></tr>
                <tr> <td>Год</td><td>${x.year}</td></tr>
                <tr> <td>Цена</td><td>${x.price}</td></tr>
            </table>
        </div>
    </c:forEach>

</div>

</body>
</html>