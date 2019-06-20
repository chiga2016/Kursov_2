<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.05.2019
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addCar</title>
</head>
<body>
<h3> Create Car</h3>
<br>
<form action="/admin/editcar" method="post">
    <input name="id" value= value=${cars.id} hidden />
    <h5>Name</h5><input title="name" type="text" name="name"  value=${cars.name}><br>
    <h5>Model</h5><input title="model" type="text" name="model"  value=${cars.model}><br>
    <h5>Transmission</h5>
    <input type="radio" id="contactChoice1"
           name="transmission" value="MT" checked>
    <label for="contactChoice1">MT</label>

    <input type="radio" id="contactChoice2"
           name="transmission" value="AT">
    <label for="contactChoice2">AT</label>
    <br>

    <h5>Year</h5><input title="year" type="text" name="year" value=${cars.year}><br>
    <h5>Price</h5><input title="price" type="text" name="price" value=${cars.price}><br>

    <input type="submit" name="OK" value="OK">
</form>
</body>
</html>
