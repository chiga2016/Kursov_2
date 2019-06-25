<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>ProfilePage</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="/resources/css/profilepage.css" rel="stylesheet">
    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
        <script type="text/javascript">
            location="http://localhost:8090/admin";
        </script>
        <!--<meta http-equiv="refresh" content="0;http://localhost:8090/admin">-->
    </c:if>
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm"  method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <h3>Добро пожаловать ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
        <a href="/welcome"><h3>Личный кабинет</h3></a>
    <div class="profileInfo">
        <table>
            <tr>
                <td>id</td>
                <td class="prof">${u.id}</td>
            </tr>
            <tr>
                <td >Имя пользователя</td>
                <td class="prof">${u.username}</td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td class="prof">${u.fam}</td>
            </tr>
            <tr>
                <td>Имя</td>
                <td class="prof">${u.name}</td>
            </tr>
            <tr>
                <td>Отчество</td>
                <td class="prof">${u.ot}</td>
            </tr>
            <tr>
                <td>Дата рождения</td>
                <td class="prof">${u.dr}</td>
            </tr>
            <tr>
                <td>Водительское удостоверение</td>
                <td class="prof">${u.vuNumber}</td>
            </tr>
            <tr>
                <td>Телефон</td>
                <td class="prof">${u.phone}</td>
            </tr>
            <tr hidden>
                <td>Пароль</td>
                <td class="prof">${u.password}</td>
            </tr>
            <tr hidden>
                <td>Подтвердите пароль</td>
                <td class="prof">${u.confirmPassword}</td>
            </tr>
            <tr>
                <td>Арендованный автомобиль</td>
                <td class="prof">
                    <label> ${u.currentCar.name} </label>
                    <form action="delCarToUser" method="post">
                        <input name="idUser" hidden value=${u.id}  >
                        <%--<br>--%>
                        <%--<h3> На данный момент за вами автомобиль: </h3>--%>
                        <%--<input type="text" value="${u.currentCar.name}" size="50"> </input>--%>
                        <input type="submit" <c:if test="${u.currentCar==null}" > hidden</c:if> value="Освободить">
                    </form>
                </td>
            </tr>
            <tr hidden>
                <td>enabled</td>
                <td class="prof">${u.enabled}</td>
            </tr>
            <tr>
                <td>Дата регистрации</td>
                <td class="prof">${u.dateCreate}</td>
            </tr>
            <tr hidden>
                <td>Роль</td>
                <td class="prof">
                    <ul>
                        <c:forEach var="x" items="${u.roles}" >
                            <li>${x.name}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </table>
</div>
        <div class="selectCar">
            <table class="selectCarTable">
                <caption> Каталог автомобилей </caption>
                <c:forEach var="car" items="${allCars}">
                    <tr
                    <c:if test="${car.available == 'true'}">
                        class="trueAvailiable"
                    </c:if>
                    <c:if test="${car.available == 'false'}">
                        class="falseAvailiable"
                    </c:if>
                    onclick="window.location.href='/cars/' + ${car.id} ; return false"><td> ${car.id}. ${car.name}, Модель: ${car.model}, Трансмиссия: ${car.transmission}, Год: ${car.year}, Прайс: ${car.price}, Доступность: ${car.available} </td></tr>
                </c:forEach>
            </table>
            <form action="addCarToUser" method="post" hidden>
                <input name="idUser" hidden value=${u.id} >
                <h4> Доступные автомобили </h4>
                <select name="idCar" >
                    <c:forEach var="y" items="${cars}">
                        <option  value=${y.id}> ${y.name}, Модель: ${y.model}, Трансмиссия: ${y.transmission}, Год: ${y.year}, Прайс: ${y.price}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Арендовать">
            </form>
            <div>
                <table class="jurnalAr">
                    <th>id</th> <th>eliminDate</th> <th>regDate</th> <th> duration</th><th> cost</th><th> car </th>
                    <caption> Журнал аренды </caption>
                    <c:forEach var="j" items="${jurnal}">
                        <tr>
                        <td> ${j.id}</td>
                        <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "medium" value = "${j.eliminDate}" /></td>
                        <td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "medium" value = "${j.regDate}" /></td>
                        <td>${j.duration}</td>
                        <td>${j.cost}</td>
                        <td>${j.cars.name}</td>
                        </tr>
                    </c:forEach>
                    <%--http://localhost:8090/jurnal/2--%>
                </table>
            </div>
            <br>
            <div>
                <%--onclick="jurnal()"--%>
                <button id="j" hidden >jurnal</button>
                <%--<button onclick="remove()">Remove</button>--%>
                <%--<ul id="lst"></ul>--%>
                <table id= "table" class="jsonTableJurnal"> </table>
                <script>
                    window.onload=function(){
                        var btn = document.getElementById("j");
                        btn.addEventListener("click", jurnal);
                    function jurnal() {
                        //var u = document.getElementById('lst');
                        //var p = document.createElement("li")
                        // p.innerHTML = 'Hello' +(u.children.length+1);
                        // u.appendChild( p )
                        fetch('http://localhost:8090/jurnal/'+${u.id})
                            .then(function(response) {
                                return response.json();
                            })
                            .then(function(myJson) {
                                // var u = document.getElementById('table');
                                var u = document.getElementById('table');
                                var p = document.createElement("tr")
                                p.innerHTML=`<th>id</th> <th>eliminDate</th> <th>regDate</th> <th> duration</th><th> cost</th><th> car </th>`
                                u.appendChild(p)
                                for (var i = 0; i < myJson.length; i++) {
                                    console.log(myJson[i])
                                    console.log(myJson[i].id)
                                    var id = myJson[i].id
                                    if(myJson[i].eliminDate != null)
                                        { var eliminDate = (new Date(myJson[i].eliminDate)).toLocaleString() } else {var eliminDate=0}
                                    if(myJson[i].regDate != null)
                                    { var regDate = (new Date(myJson[i].regDate)).toLocaleString() } else {var regDate=0}
                                    var duration = myJson[i].duration
                                    var cost = myJson[i].cost
                                    var carName = ""//myJson[i].cars.name
                                    var p = document.createElement("tr")
                                    //var p1 = document.createElement("li")
                                    <%--p1.innerHTML=${myJson[i].id}--%>
                                    <%--p.innerHTML=`<td>${myJson[i].id}</td><td>${myJson[i].eliminDate}</td><td>${myJson[i].regDate}</td><td>${myJson[i].duration}</td><td>${myJson[i].cost}</td>`--%>
                                    p.innerHTML="<td>" + id +"</td><td>"+eliminDate+"</td><td>"+ regDate +"</td><td>"+duration+"</td><td>"+cost+"</td><td>"+carName+"</td>"
                                    console.log(p.innerHTML)
                                    //document.write(myJson[i].id);
                                    u.appendChild(p)
                                    //u1.appendChild(p1)
                                    <%--<td><button onclick="deleteCat(${myJson[i].id})">X</button></td>--%>
                                }
                                //document.write('</table>')
                                btn.removeEventListener("click", jurnal)
                            });
                    }}
                </script>
            </div>
        </div>
    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

