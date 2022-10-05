<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

    <div class="container">
        <div class="row justify-content-center">
            <c:if test="${recipes != null}">
            <c:forEach items="${recipes}" var="recipe">
                <div class="card col-3 p-0 m-1">
                    <img src="${recipe.photoUrl}" class="card-img-top w-100" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                        <p class="card-text">${recipe.description}</p>
                        <a href="${pageContext.request.contextPath}/recipe" class="btn btn-primary">View</a>
                    </div>
                </div>
            </c:forEach>
            </c:if>
        </div>
    </div>


</body>
</html>
