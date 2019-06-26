<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Edit Car</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="/resources/css/admin.css" rel="stylesheet">

</head>
<body>
<div class="addCar">
    <h3> Редактирование автомобиля</h3>
    <br>
<form action="/admin/editcar" method="post">
    <input name="id" value= ${cars.id} hidden />
    <h5>Name</h5><input title="name" type="text" name="name"  value=${cars.name}><br>
    <h5>Marka</h5><input title="marka" type="text" name="marka"  value=${cars.marka}><br>
    <h5>Model</h5><input title="model" type="text" name="model"  value=${cars.model}><br>

    <h5>Transmission</h5>

    <c:if test="${cars.transmission == 'MT'}">
        <input type="radio" id="contactChoice1"
               name="transmission" value="MT" checked>
        <label for="contactChoice1">MT</label>

        <input type="radio" id="contactChoice2"
               name="transmission" value="AT">
        <label for="contactChoice2">AT</label>
        <br>
    </c:if>
    <c:if test="${cars.transmission == 'AT'}">
        <input type="radio" id="contactChoice1"
               name="transmission" value="MT" >
        <label for="contactChoice1">MT</label>

        <input type="radio" id="contactChoice2"
               name="transmission" value="AT" checked>
        <label for="contactChoice2">AT</label>
        <br>
    </c:if>
    <h5>Year</h5><input title="year" type="text" name="year" value=${cars.year}><br>
    <h5>Price</h5><input title="price" type="text" name="price" value=${cars.price}><br>
    <h5>img</h5><input title="img"  type="text" name="img" value=${cars.img}><br>

    <h5>img</h5><input title="img" type="file" name="img"><br>

    <h5>Доступен</h5>
    <c:if test="${cars.available == 'true'}">
        <input name="available" placeholder="available"  type="checkbox" checked /><br>
    </c:if>
    <c:if test="${cars.available == 'false'}">
        <input name="available" placeholder="available"  type="checkbox" /><br>
    </c:if>


    <input type="submit" name="OK" value="OK">
</form>
</body>
</html>
