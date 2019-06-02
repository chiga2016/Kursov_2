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

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>


        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>username</label>
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true" value="BalagutdinovIF" ></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="fam">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>fam</label>
                <form:input type="text" path="fam" class="form-control" placeholder="fam"  value="Balagutdinov" ></form:input>
                <form:errors path="fam"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>name</label>
                <form:input type="text" path="name" class="form-control" placeholder="name"  value="Ilgiz" ></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>password</label>
                <form:input type="password" path="password" class="form-control" placeholder="Password"  value="Balagutdinov" ></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label>confirmPassword</label>
            <form:input type="password" path="confirmPassword" class="form-control"
                        placeholder="Confirm your password"   value="Balagutdinov" ></form:input>
            <form:errors path="confirmPassword"></form:errors>
        </div>
    </spring:bind>

        <spring:bind path="ot">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>ot</label>
                <form:input type="text" path="ot" class="form-control"
                            placeholder="ot"   value="Faritovich" ></form:input>
                <form:errors path="ot"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="dr">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>dr</label>
                <form:input type="date" path="dr" class="form-control"
                            placeholder="dr"   value="1986-12-25" ></form:input>
                <form:errors path="dr"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="vuNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>vuNumber</label>
                <form:input type="text" path="vuNumber" class="form-control"
                            placeholder="vuNumber"   value="0207727737" ></form:input>
                <form:errors path="vuNumber"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label>phone</label>
                <form:input type="tel" path="phone" class="form-control"
                            placeholder="phone"   value="79899520151" ></form:input>
                <form:errors path="phone"></form:errors>
            </div>
        </spring:bind>



        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>