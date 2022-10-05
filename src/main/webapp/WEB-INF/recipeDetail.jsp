<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container" style="align-content: center;max-width: 40%; padding: 30px;">
    <div class="card">
        <img class="card-img-top " src="${recipe.photoUrl}" alt="${recipe.name}">
        <div class="card-body text-center">
            <h5 class="card-title">${recipe.name}</h5>
            <p class="card-text">${recipe.description}</p>
        </div>

        <c:if test = "${sessionScope.user != null}">
            <form action="${pageContext.request.contextPath}/recipe" method="post">
                <input hidden name="id" value="${recipe.id}">
                <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Recette cuisinee aujourd'hui</button>
            </form>
        </c:if>

        <c:if test = "${sessionScope.user == authorid}">
            <a href="${pageContext.request.contextPath}/recipe/Update?id=${recipe.id}" class="btn btn-primary">Edit</a>
            <a href="${pageContext.request.contextPath}/StepIngredient/Update?id=${recipe.id}" class="btn btn-primary">Edit ingredient + step</a>
        </c:if>

        <div class="row">
            <div class="col-lg-4 mb-1">
                <p>type : ${recipe.type}</p>
            </div>
            <div class="col-lg-4 mb-1">
                <p>tmps-prep : ${recipe.prepTime}</p>
            </div>
            <div class="col-lg-4 mb-1">
                <p>tmps-cuiss : ${recipe.cookTime}</p>
            </div>
            <div class="col-lg-4 mb-1">
                <p>tmps-rep : ${recipe.restTime}</p>
            </div>
            <div class="col-lg-4 mb-1">
                <p>difficulty : ${recipe.dificulty}</p>
            </div>
            <div class="col-lg-4 mb-1">
                <p>coût : ${recipe.price}</p>
            </div>
        </div>

        <div class="row">
            <c:forEach items="${recipeIngredients}" var="ringredient">
                <div class="center-text col-lg-3 mb-1">
                    <div class="container text-center" style="max-width: 50px;">
                        <img src="${ringredient.ingredientByIngId.photoUrl}" alt="${ringredient.ingredientByIngId.name}" class="card-img-top embed-responsive-item">
                        <p class="card-title">${ringredient.quantity} ${ringredient.unit}</p>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="container mb-3">
            <c:forEach items="${steps}" var="step">
                <p><strong>Etape ${step.stepNumber}</strong></p>
                <p> </p>
                <p>${step.text}</p>
            </c:forEach>
        </div>

<%--        <div class="card-body mb-3">--%>
<%--            <c:forEach items="${comments}" var="comment">--%>
<%--                <p>commentaire laissé par <a href="#">${comment.userByUserId.firstname}</a></p>--%>
<%--                <p><strong>Note ${comment.rating}/5</strong></p>--%>
<%--                <p> </p>--%>
<%--                <div class="container mb-3">--%>
<%--                    <p>${comment.textComment}</p>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
    </div>
</div>



</body>
</html>
