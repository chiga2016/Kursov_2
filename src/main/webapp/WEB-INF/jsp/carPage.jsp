<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CarPage</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="/resources/css/carpage.css" rel="stylesheet">
</head>
<body>
<div class="container">
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm"  method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></form>

    <h2>Добро пожаловать ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>

    <a href="/welcome"> <h3>Перейти в личный кабинет</h3> </a>

    <h1>Профиль автомобиля</h1>

<div class="carInfo">
    <table>
        <tr>
            <td>id</td>
            <td class="prof">${car.id}</td>
        </tr>
        <tr>
            <td>name</td>
            <td class="prof">${car.name}</td>
        </tr>
        <tr>
            <td>model</td>
            <td class="prof">${car.model}</td>
        </tr>
        <tr>
            <td>tranmission</td>
            <td class="prof">${car.transmission}</td>
        </tr>
        <tr>
            <td>year</td>
            <td class="prof">${car.year}</td>
        </tr>
        <tr>
            <td>price</td>
            <td class="prof">${car.price}</td>
        </tr>
        <tr>
            <td>available</td>
            <td class="prof">${car.available}</td>
        </tr>
    </table>
    <form action="http://localhost:8090/addCarToUser" method="post">
        <input name="idUser" hidden value=${user.id} >
        <input name="idCar" hidden value=${car.id} >
        <input type="submit" value="Арендовать">
    </form>

    </c:if>
</div>
</div>
</body>
</html>
