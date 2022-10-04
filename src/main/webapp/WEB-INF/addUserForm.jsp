<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container text-center">

    <h1>Add user</h1>

    <form action="${pageContext.request.contextPath}/addUser" method="post" class="w-75 mx-auto">
        <div class="form-label-group mb-3">
            <input id="firstname" type="text" name="firstname" placeholder="firstname" class="form-control" required>
        </div>

        <div class="form-label-group mb-3">
            <input id="lastname" type="text" name="lastname" placeholder="lastname" class="form-control">
        </div>

        <div class="form-label-group mb-3">
            <input id="photoUrl" type="text" name="photoUrl" placeholder="Photo link" class="form-control">
        </div>

        <div class="form-label-group mb-3">
            <input id="email" type="email" name="emailAddress" placeholder="E-mail address" class="form-control" required>
        </div>


        <div class="form-label-group mb-3">
            <input id="password" type="password" name="password" placeholder="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Sign up</button>

    </form>

</div>

</body>
</html>
