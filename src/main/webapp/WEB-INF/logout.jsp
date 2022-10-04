<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container text-center">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h3 class="card-title text-center mb-5">ARE YOU SURE YOU WANT TO LOGOUT?</h3>
                    <form action="${pageContext.request.contextPath}/logout" method="post">
                        <div class="row justify-content-between">
                            <button class=" col-3 btn btn-success btn-login text-uppercase fw-bold" type="submit">YES</button>
                            <a class="col-3 btn btn-danger btn-login text-uppercase fw-bold"  href="${pageContext.request.contextPath}/listCar" type="submit">NO</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
