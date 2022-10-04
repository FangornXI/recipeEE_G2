<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="stylesheet.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <title>Recipe Project | Login</title>

    <style type="text/css">
        .container{
            max-width: 600px;
        }

    </style>

</head>
<body>

<div class="container text-center">

    <h1>Login</h1>

    <form action="${pageContext.request.contextPath}/login" method="post">

        <div class="form-label-group mb-3">
            <input id="email" type="email" name="emailAddress" placeholder="E-mail address" class="form-control" required>
        </div>


        <div class="form-label-group mb-3">
            <input id="password" type="password" name="password" placeholder="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Login</button>

    </form>

</div>

</body>
</html>
