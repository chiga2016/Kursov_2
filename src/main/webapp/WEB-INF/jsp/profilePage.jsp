<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ProfilePage</title>

    <!--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

        <h1>ProfilePage</h1>

        <table>
            <tr>
                <td>id</td>
                <td>${u.id}</td>
            </tr>
            <tr>
                <td>username</td>
                <td>${u.username}</td>
            </tr>
            <tr>
                <td>fam</td>
                <td>${u.fam}</td>
            </tr>
            <tr>
                <td>name</td>
                <td>${u.name}</td>
            </tr>
            <tr>
                <td>ot</td>
                <td>${u.ot}</td>
            </tr>
            <tr>
                <td>dr</td>
                <td>${u.dr}</td>
            </tr>
            <tr>
                <td>vuNumber</td>
                <td>${u.vuNumber}</td>
            </tr>
            <tr>
                <td>phone</td>
                <td>${u.phone}</td>
            </tr>
            <tr>
                <td>password</td>
                <td>${u.password}</td>
            </tr>
            <tr>
                <td>confirmPassword</td>
                <td>${u.confirmPassword}</td>
            </tr>
            <tr>
                <td>enabled</td>
                <td>${u.enabled}</td>
            </tr>
            <tr>
                <td>dateCreate</td>
                <td>${u.dateCreate}</td>
            </tr>
            <tr>
                <td>Roles</td>
                <td>
                    <ul>
                        <c:forEach var="x" items="${u.roles}">
                            <li>${x.name}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>
        <%--<br>--%>
        <%--${ustring}--%>
        <%--<br>--%>

        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>model</th>
                <th>transmission</th>
                <th>year</th>
            </tr>
            <c:forEach var="y" items="${cars}">
                <tr>
                    <td><a href="/admin/editcar">${y.id}</a></td>
                    <td>${y.name}</td>
                    <td>${y.model}</td>
                    <td>${y.transmission}</td>
                    <td>${y.year}</td>
                </tr>
            </c:forEach>
        </table>


    </c:if>

</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>