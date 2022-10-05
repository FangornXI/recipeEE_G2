<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container text-center">

    <h1>Login</h1>
    <div>
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
    <div class="col-md-8 col-md-offset-2 mt-20">
        <c:if test="${message!=null}">
                <div id="msg" class="form-message error text-center white-text">
                    <p>${message}</p>
                </div>
        </c:if>
    </div>
</div>

</body>
</html>
