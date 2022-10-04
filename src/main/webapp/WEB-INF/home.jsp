<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>
<c:if test="${recipes} != null">


<c:forEach items="recipes" var="recipe">
    <input hidden name="idRecipe" value="${recipe.id}">
    <div class="card" style="width: 18rem;">
        <img src="${recipe.photoUrl}" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${recipe.name}</h5>
            <p class="card-text">${recipe.description}</p>
            <a href="${pageContext.request.contextPath}/recipe" class="btn btn-primary">View</a>
        </div>
    </div>

</c:forEach>
</c:if>

</body>
</html>
