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
</div>
    <div class="carCost">
        <form name="costDivForm">
            <label>Начало бронирования</label>
            <input class="d1" type="date" name="date1" value="2019-06-16"/>
            <input class="t1" type="time" name="time1" value="23:00">
            <label>Конец бронирования</label>
            <input class="d2" type="date" name="date2" value="2019-06-16"/>
            <input class="t2" type="time" name="time2" value="23:55">
        </form>
            <p id="p"></p>
            <button name = "carCostButton" onclick = "costFunction()" value="Рассчитать"></button>
            <%--<button id="demo" value="Рассчитать"></button>--%>
            <script>
                // window.onload=function(){
                //     var btn = document.getElementById("demo");
                //     btn.addEventListener("click", costFunction);

                function costFunction() {
                    var d1=document.querySelector('[name="date1"]');
                    var t1=document.querySelector('[name="time1"]');
                    var date1 = new Date((d1.value +" "+ t1.value).replace(/-/g,"/"))

                    var d2=document.querySelector('[name="date2"]');
                    var t2=document.querySelector('[name="time2"]');
                    var date2 = new Date((d2.value +" "+ t2.value).replace(/-/g,"/"))
                    var duration = date2.getTime() - date1.getTime()

                    var u = document.getElementById('p');
                    var url = 'http://localhost:8090/cars?dur='+duration+'&car='+${car.id}
                    fetch('http://localhost:8090/cars?dur='+duration+'&car='+${car.id})
                        .then(function(response) {
                            return response.json();
                        })
                        .then(function(myJson) {
                            u.innerHTML = 'Предварительная стоимость = ' + myJson.toString()
                            //document.write(myJson.toString()) ;
                        });
                }
            </script>

    </div>
    </c:if>
</body>
</html>
