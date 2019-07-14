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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <script src="${contextPath}/resources/script.js"></script>
</head>

<body style="background-image: url('/resources/img/2.jpg'); background-position: top">

<header>
    <nav id="top_nav" style="top: 0px;">
        <ul>
            <li><a href="${contextPath}/">Главная</a> </li>
            <li> <a href="${contextPath}/bazaavto">База автомобилей</a> </li>
            <li><a href="${contextPath}/resources/Pravila.html">Правила</a></li>
            <li><a href="${contextPath}/resources/kontakt.html">Контакты</a> </li>
            <li> <a href="${contextPath}/registration">Регистрация</a> </li>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li> <a href="welcome"> ${pageContext.request.userPrincipal.name}</a> </li>
                <li> <a onclick="document.forms['logoutForm'].submit()">Выйти</a> </li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li> <a href="${contextPath}/login">Войти</a> </li>
            </c:if>
        </ul>
    </nav>
    /<header>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Регистрация</h2>

        <style type="text/css">
            .reg {
                width: 100%; /* Ширина всей таблицы */
            }
            TD {
                vertical-align: top;
                horiz-align: left/* Вертикальное выравнивание в ячейках */
               }
             </style>

        <table cellspacing="0" class="reg">
            <tr>
                <td class="leftcol">

                    <spring:bind path="username">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Имя пользователя</label>
                            <form:input type="text" path="username" class="form-control" placeholder="Username"
                                        autofocus="true" value="BalagutdinovIF" ></form:input>
                            <form:errors path="username"></form:errors>
                        </div>
                    </spring:bind>
                </td>
                <td class="spacer"></td>
                <td cla ="rightcol">
                      <spring:bind path="fam">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Фамилия</label>
                            <form:input type="text" path="fam" class="form-control" placeholder="fam"  value="Balagutdinov" ></form:input>
                            <form:errors path="fam"></form:errors>
                        </div>
                    </spring:bind>
                </td>

                    </tr>

            <tr>
                <td class="leftcol">
        <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Пароль</label>
                            <form:input type="password" path="password" class="form-control" placeholder="Password"  value="1111" ></form:input>
                            <form:errors path="password"></form:errors>
                        </div>
                    </spring:bind>
                </td>
                <td class="spacer"></td>
                <td cla ="rightcol">
                    <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label>Имя</label>
                        <form:input type="text" path="name" class="form-control" placeholder="name"  value="Ilgiz" ></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                    </spring:bind>
                </td>

            </tr>

            <tr>
                <td class="leftcol">
        <spring:bind path="confirmPassword">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Подтвердите </label>
                            <form:input type="password" path="confirmPassword" class="form-control"
                                        placeholder="Confirm your password"   value="1111" ></form:input>
                            <form:errors path="confirmPassword"></form:errors>
                        </div>
                    </spring:bind>
                </td>
                <td class="spacer"></td>
                <td cla ="rightcol">
        <spring:bind path="ot">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Отчество</label>
                            <form:input type="text" path="ot" class="form-control"
                                        placeholder="ot"   value="Faritovich" ></form:input>
                            <form:errors path="ot"></form:errors>
                        </div>
                    </spring:bind>
                </td>

            </tr>

            <tr>
                <td class="leftcol">
                </td>
            <td class="spacer"></td>
            <td class ="rightcol">
            <spring:bind path="dr">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Дата рождения</label>
                            <form:input type="date" path="dr" class="form-control"
                                        placeholder="dr"   value="1986-12-25" ></form:input>
                            <form:errors path="dr"></form:errors>
                        </div>
                    </spring:bind>
            </td>
            </tr>

            <tr>
                <td class="leftcol">
                </td>
                <td class="spacer"></td>
                <td class ="rightcol">
                    <spring:bind path="vuNumber">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Водительское удостоверение</label>
                            <form:input type="text" path="vuNumber" class="form-control"
                                        placeholder="vuNumber"   value="0207727737" ></form:input>
                            <form:errors path="vuNumber"></form:errors>
                        </div>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td class="leftcol">
                </td>
                <td class="spacer"></td>
                <td class ="rightcol">
                    <spring:bind path="phone">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label>Телефон</label>
                            <form:input type="tel" path="phone" class="form-control"
                                        placeholder="phone"   value="79899520151" ></form:input>
                            <form:errors path="phone"></form:errors>
                        </div>
                    </spring:bind>

                  </td>

            </tr>

        </table>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>