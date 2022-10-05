<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container text-center">

    <h1>${type} user</h1>

    <form action="${pageContext.request.contextPath}/user/${type}" method="post">
        <input hidden name="type" value="${type}">
        <div class="form-label-group mb-3">
            <input id="firstname" type="text" name="firstname" placeholder="firstname" class="form-control" value="${user.firstname}" required>
        </div>

        <div class="form-label-group mb-3">
            <input id="lastname" type="text" name="lastname" placeholder="lastname" class="form-control" value="${user.lastname}">
        </div>

        <div class="form-label-group mb-3">
            <input id="photoUrl" type="text" name="photoUrl" placeholder="Photo link" class="form-control" value="${user.photoUrl}">
        </div>

        <div class="form-label-group mb-3">
            <input id="email" type="email" name="emailAddress" placeholder="E-mail address" class="form-control" value="${user.email}" required>
        </div>


        <div class="form-label-group mb-3">
            <input id="password" type="password" name="password" class="form-control" autocomplete="new-password" placeholder="password" value="${user.password}"
            <c:if test = "${sessionScope.user == null}" var="condition">
                    required
            </c:if>
            >
        </div>

        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">${type}</button>

    </form>

</div>

</body>
</html>
