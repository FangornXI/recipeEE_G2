<%--
  Created by IntelliJ IDEA.
  User: Mohamed ZEFIZEF
  Date: 04/10/2022
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe Project | add user</title>
</head>
<body>

<div class="container text-center">

    <h1>Add user</h1>

    <form action="${pageContext.request.contextPath}/addCountry" method="post">
        <div class="form-label-group">
            <input id="firstname" type="text" name="firstname" placeholder="firstname" class="form-control">
        </div>

        <div class="form-label-group">
            <input id="lastname" type="text" name="lastname" placeholder="lastname" class="form-control">
        </div>

        <div class="form-label-group">
            <input id="photoUrl" type="text" name="photoUrl" placeholder="Photo link" class="form-control">
        </div>

        <div class="form-label-group">
            <input id="email" type="email" name="emailAddress" placeholder="E-mail address" class="form-control">
        </div>


        <div class="form-label-group">
            <input id="password" type="password" name="password" placeholder="password" class="form-control">
        </div>

        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Sign up</button>

    </form>

</div>

</body>
</html>
