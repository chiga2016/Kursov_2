<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Edit an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>

<body style="background-image: url('/resources/img/light2.jpg'); background-position: top">

<div class="container">

    <form:form method="POST" action="/admin/edituser" modelAttribute="userForm"  class="form-signin">
        <h4 class="form-signin-heading">Редактирование данных пользователя</h4>

        <%--<style type="text/css">--%>
            <%--.reg {--%>
                <%--width: 100%; /* Ширина всей таблицы */--%>
            <%--}--%>
            <%--TD {--%>
                <%--vertical-align: top;--%>
                <%--horiz-align: left/* Вертикальное выравнивание в ячейках */--%>
            <%--}--%>
        <%--</style>--%>
        <table cellspacing="0" class="reg">
            <tr>
                <td class="leftcol" hidden>
                    <spring:bind path="id">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" path="id" class="form-control"  value="${userForm.id}" ></form:input>
                            <form:errors path="id"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td class="leftcol">
                    <spring:bind path="username">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Имя пользователя</label>
                            <form:input type="text" path="username" class="form-control" placeholder="Username"
                                        autofocus="true" value="${userForm.username}" readonly="true" ></form:input>
                            <form:errors path="username"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <%--<td class="spacer"></td>--%>
                <td cla ="leftcol">
                    <spring:bind path="fam">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Фамилия</label>
                            <form:input type="text" path="fam" class="form-control" placeholder="fam"  value="${userForm.fam}" ></form:input>
                            <form:errors path="fam"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td class="leftcol" hidden>
                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Пароль</label>
                            <form:input type="password" path="password" class="form-control" placeholder="Password"  value="${userForm.password}" ></form:input>
                            <form:errors path="password"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <%--<td class="spacer"></td>--%>
                <td class ="leftcol">
                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Имя</label>
                            <form:input type="text" path="name" class="form-control" placeholder="name"  value="${userForm.name}" ></form:input>
                            <form:errors path="name"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td class="leftcol" hidden>
                    <spring:bind path="confirmPassword">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Подтвердите </label>
                            <form:input type="password" path="confirmPassword" class="form-control"
                                        placeholder="Confirm your password"   value="1111" ></form:input>
                            <form:errors path="confirmPassword"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <%--<td class="spacer"></td>--%>
                <td class ="leftcol">
                    <spring:bind path="ot">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Отчество</label>
                            <form:input type="text" path="ot" class="form-control"
                                        placeholder="ot"   value="${userForm.ot}" ></form:input>
                            <form:errors path="ot"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <%--<td class="spacer"></td>--%>
                <td class ="leftcol">
                    <spring:bind path="dr">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Дата рождения</label>
                            <form:input type="date" path="dr" class="form-control"
                                        placeholder="dr"   value="${userForm.dr}" ></form:input>
                            <form:errors path="dr"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <%--<td class="spacer"></td>--%>
                <td class ="leftcol">
                    <spring:bind path="vuNumber">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Водительское удостоверение</label>
                            <form:input type="text" path="vuNumber" class="form-control"
                                        placeholder="vuNumber"   value="${userForm.vuNumber}" ></form:input>
                            <form:errors path="vuNumber"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <%--<td class="spacer"></td>--%>
                <td class ="leftcol">
                    <spring:bind path="phone">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Телефон</label>
                            <form:input type="tel" path="phone" class="form-control"
                                        placeholder="phone"   value="${userForm.phone}" ></form:input>
                            <form:errors path="phone"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                    <td class ="leftcol">
                        <spring:bind path="enabled">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label>Активный</label>
                                <c:if test="${userForm.enabled == 'true'}">
                                    <input name="enabled" placeholder="enabled"  type="checkbox" checked /><br>
                                </c:if>
                                <c:if test="${userForm.enabled == 'false'}">
                                    <input name="enabled" placeholder="enabled"  type="checkbox" /><br>
                                </c:if>
                            </div>
                        </spring:bind>
                    </td>

            </tr>
        </table>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Отредактировать данные</button>
    </form:form>


    <%--<form action="/admin/edituser" method="post">--%>
        <%--<input name="id" type="text" hidden  value=${users.id}  /><br>--%>
       <%--&lt;%&ndash;<label>username</label> <input name="username" placeholder="username" type="text" value=${users.username} /><br>&ndash;%&gt;--%>

        <%--<spring:bind path="username">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<label>Имя пользователя</label>--%>
                <%--<form:input type="text" path="username" class="form-control" placeholder="Username"--%>
                            <%--autofocus="true" value="${users.username}"  ></form:input>--%>
                <%--<form:errors path="username"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>
        <%--<label>fam</label> <input name="fam" placeholder="fam"  type="text" value=${users.fam} /><br>--%>
        <%--<label>name</label> <input name="name"  placeholder="name" type="text" value=${users.name} /><br>--%>
        <%--<label>ot</label> <input name="ot" placeholder="ot"  type="text" value=${users.ot} /><br>--%>
        <%--<label>dr</label> <input name="dr" placeholder="dr"  type="date" value=${users.dr} /><br>--%>
        <%--<label>phone</label> <input name="phone" placeholder="phone"  type="tel" value=${users.phone} /><br>--%>
        <%--<label>vuNumber</label> <input name="vuNumber" placeholder="vuNumber"  type="text" value=${users.vuNumber} /><br>--%>
        <%--&lt;%&ndash;<label>password</label> <input name="password" placeholder="password"  type="text" value=${users.password} /><br>&ndash;%&gt;--%>
        <%--<label>enabled</label>--%>
        <%--<c:if test="${users.enabled == 'true'}">--%>
            <%--<input name="enabled" placeholder="enabled"  type="checkbox" checked /><br>--%>
        <%--</c:if>--%>
        <%--<c:if test="${users.enabled == 'false'}">--%>
            <%--<input name="enabled" placeholder="enabled"  type="checkbox" /><br>--%>
        <%--</c:if>--%>

         <%--<input name="submit" type="submit" />--%>
    <%--</form>--%>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>