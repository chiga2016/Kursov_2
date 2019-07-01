<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Прокат автомобилей</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <script src="/resources/script.js"></script>
</head>

<body padding-top: 30px;>
<header>
    <nav id="top_nav" style="top: 0px;">
        <ul>
            <li><a href="/">Главная</a> </li>
            <li> <a href="/bazaavto">База автомобилей</a> </li>
            <li><a href="/resources/Pravila.html">Правила</a></li>
            <li><a href="/resources/kontakt.html">Контакты</a> </li>
            <li> <a href="/registration">Регистрация</a> </li>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <%--<form id="logoutForm"  method="POST" action="${contextPath}/logout">--%>
                    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
                <%--</form>--%>
                <li> <a href="welcome"> ${pageContext.request.userPrincipal.name}</a> </li>
                <li> <a onclick="document.forms['logoutForm'].submit()">Выйти</a> </li>

            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li> <a href="/login">Войти</a> </li>
            </c:if>


        </ul>
    </nav>
</header>
<div class="glavnaya">


    <div data-am-fadeshow="next-prev-navigation">

        <!-- Radio -->
        <input type="radio" name="css-fadeshow" id="slide-1" />
        <input type="radio" name="css-fadeshow" id="slide-2" />
        <input type="radio" name="css-fadeshow" id="slide-3" />

        <!-- Slides -->
        <div class="fs-slides">
            <div class="fs-slide" style="background-image: url('/resources/img/1.jpg');">
                <!-- Add content to images (sample) -->
                <div style="position: absolute; top: 30%; left: 30%; transform: translate(-50%, -50%); color: white; font-family: sans-serif; text-align: center; text-shadow: 0 0 20px rgba(0,0,0,0.5);">
                    <h1 style="margin-top: 0; margin-bottom: vw; font-size: 4vw; font-weight: bold; text-align: left;">Прокат автомобилей <br>в Уфе</h1>
                    <!-- <p style="font-size: 3vw; font-weight: 100; margin-top: 0;">Легче чем<strong>вы</strong> думаете!</p>
                    <p style="font-size: 3vw; font-weight: 100; margin-top: 0;">Всего<strong>5 руб/мин</strong> !</p> -->
                </div>
            </div>
            <div class="fs-slide" style="background-image: url('resources/img/2.jpg');"></div>
            <div class="fs-slide" style="background-image: url('resources/img/3.jpg');"></div>
        </div>

        <!-- Quick Navigation -->
        <div class="fs-quick-nav">
            <label class="fs-quick-btn" for="slide-1"></label>
            <label class="fs-quick-btn" for="slide-2"></label>
            <label class="fs-quick-btn" for="slide-3"></label>
        </div>

        <!-- Prev Navigation -->
        <div class="fs-prev-nav">
            <label class="fs-prev-btn" for="slide-1"></label>
            <label class="fs-prev-btn" for="slide-2"></label>
            <label class="fs-prev-btn" for="slide-3"></label>
        </div>

        <!-- Next Navigation -->
        <div class="fs-next-nav">
            <label class="fs-next-btn" for="slide-1"></label>
            <label class="fs-next-btn" for="slide-2"></label>
            <label class="fs-next-btn" for="slide-3"></label>
        </div>

    </div>

</div>


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


</body>
</html>
