<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>add car</title>
</head>
<body>
<h3> Create Car</h3>
<br>
<form action="/admin/addcar" method="post">
    <h5>Name</h5><input title="name" type="text" name="name"><br>
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
    <input type="submit" name="OK" value="OK">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
