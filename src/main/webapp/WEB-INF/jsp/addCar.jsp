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

    <title>Create Car</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/admin.css" rel="stylesheet">

</head>
<body style="background-image: url('/resources/img/light2.jpg'); background-position: top">

<h2><a href="${contextPath}/admin"> Страница администратора</a> </h2>

<div class="addCar">
    <h3>Добавление нового автомобиля</h3>
    <br>
<form action="${contextPath}/admin/addcar" method="post">
    <h5>Name</h5><input title="name" type="text" name="name"><br>
    <h5>Marka</h5><input title="marka" type="text" name="marka"><br>
    <h5>Model</h5><input title="model" type="text" name="model"><br>
    <h5>Transmission</h5>
    <input type="radio" id="contactChoice1"
           name="transmission" value="MT" checked>
    <label for="contactChoice1">MT</label>

    <input type="radio" id="contactChoice2"
           name="transmission" value="AT">
    <label for="contactChoice2">AT</label>
    <br>

    <h5>Year</h5><input title="year" type="text" name="year"><br>
    <input title="available" type="text" name="available" value="true" hidden>
    <h5>price</h5><input title="price" type="text" name="price"><br>
    <h5>img</h5><input title="img" type="file" name="img"><br>

    <input type="submit" name="OK" value="OK">
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
