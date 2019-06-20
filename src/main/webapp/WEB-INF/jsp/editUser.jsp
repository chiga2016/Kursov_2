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

    <title>Create an account</title>
</head>

<body>

<div class="container">

    <form action="/admin/edituser" method="post">
       <label>username</label> <input name="username" placeholder="username" type="text" value=${users.username} /><br>
        <label>fam</label> <input name="fam" placeholder="fam"  type="text" value=${users.fam} /><br>
        <label>name</label> <input name="name"  placeholder="name" type="text" value=${users.name} /><br>
        <label>ot</label> <input name="ot" placeholder="ot"  type="text" value=${users.ot} /><br>
        <label>dr</label> <input name="dr" placeholder="dr"  type="date" value=${users.dr} /><br>
        <label>phone</label> <input name="phone" placeholder="phone"  type="tel" value=${users.phone} /><br>
        <label>vuNumber</label> <input name="vuNumber" placeholder="vuNumber"  type="text" value=${users.vuNumber} /><br>
        <label>password</label> <input name="password" placeholder="password"  type="text" value=${users.password} /><br>
        <label>enable</label> <input name="enable" placeholder="enable"  type="checkbox" value=${users.enabled} /><br>
         <input name="submit" type="submit" />

    </form>



</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>