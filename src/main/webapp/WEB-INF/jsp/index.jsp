<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm"  method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
<h2>Добро пожаловать ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
<a href="welcome">Личный кабинет</a>
</c:if>
<br>
<c:if test="${pageContext.request.userPrincipal.name == null}">
    <h2>Добро пожаловать </h2>
    <a href="/registration" > Зарегистрируйтесь </a> или <a href="/login" > войдите </a>
</c:if>

        <!--        <iframe src="https://yandex.ru/map-widget/v1/-/CVHL5BP9" width="560" height="400" frameborder="1" allowfullscreen="true"></iframe>
        -->


    </body>
</html>
