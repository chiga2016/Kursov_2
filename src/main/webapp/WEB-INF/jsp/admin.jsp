<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>admin</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="/resources/css/admin.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">
    <form id="logoutForm"  method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>

    <h2>Панель администрирования</h2>

    <div class="main">
        <a href="/">Главная</a> | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
    </div>


    <div class="car_div">
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>model</th>
                <th>transmission</th>
                <th>year</th>
            </tr>
            <c:forEach var="x" items="${cars}">

                    <tr>
                        <td><a href="/admin/editcar/${x.id}">${x.id}</a></td>
                        <td>${x.name}</td>
                        <td>${x.model}</td>
                        <td>${x.transmission}</td>
                        <td>${x.year}</td>
                    </tr>

            </c:forEach>

            <tr > <a href="/admin/addcar">Добавить машину </a> </tr>
        </table>
    </div>

    <div class="user_div">
        <table>
            <tr>
                    <th>id</th>
                    <th>username</th>
                    <%--<th>fam</th>--%>
                    <%--<th>name</th>--%>
                    <%--<th>ot</th>--%>
                    <%--<th>dr</th>--%>
                    <th>phone</th>
                    <th>vuNumber</th>
                    <th>dateCreate</th>
                    <th>enabled</th>
            </tr>
            <c:forEach var="x" items="${users}">

                <tr>

                        <td><a href="/admin/edituser/${x.id}">${x.id}</a></td>
                        <td>${x.username}</td>
                        <%--<td>${x.fam}</td>--%>
                        <%--<td>${x.name}</td>--%>
                        <%--<td>${x.ot}</td>--%>
                        <%--<td>${x.dr}</td>--%>
                        <td>${x.phone}</td>
                        <td>${x.vuNumber}</td>
                        <td>${x.dateCreate}</td>
                        <td>${x.enabled}</td>

                </tr>

            </c:forEach>

            <tr > <a href="/admin/adduser">Добавить клиента </a> </tr>
        </table>
    </div>


</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>