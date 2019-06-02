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

    <form action="/add/person" method="post">
       <label>username</label> <input name="username" placeholder="username" type="text" /><br>
        <label>fam</label> <input name="fam" placeholder="fam"  type="text" /><br>
        <label>name</label> <input name="name"  placeholder="name" type="text" /><br>
        <label>ot</label> <input name="ot" placeholder="ot"  type="text" /><br>
        <label>dr</label> <input name="dr" placeholder="dr"  type="date" /><br>
        <label>phone</label> <input name="phone" placeholder="phone"  type="tel" /><br>
        <label>vuNumber</label> <input name="vuNumber" placeholder="vuNumber"  type="text" /><br>
        <label>password</label> <input name="password" placeholder="password"  type="text" /><br>
         <input name="submit" type="submit" />

    </form>



</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>