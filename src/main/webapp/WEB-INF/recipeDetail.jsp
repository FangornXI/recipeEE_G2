<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>


<div class="container" style="max-width: 40%; padding: 30px;align-content: center">

    <div class="card align-items-center" style="background: #e1c9c6;align-content: center">
        <img class="card-img-top " src="${recipe.photoUrl}" alt="${recipe.name}">
        <div class="card-body text-center">
            <h5 class="card-title">${recipe.name}</h5>
            <p class="card-text">${recipe.description}</p>
        </div>

        <c:if test = "${sessionScope.user != null}">
            <div class="container"style="align-items: center">
                <form action="${pageContext.request.contextPath}/recipe" method="post">
                    <input hidden name="id" value="${recipe.id}">
                    <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Recette cuisinee aujourd'hui</button>
                </form>
            </div>
        </c:if>

        <c:if test = "${sessionScope.user == authorid}">
            <div class="container">
                <div class="row m-2 align-items-center">
                    <a href="${pageContext.request.contextPath}/recipe/Update?id=${recipe.id}" class="btn btn-primary" style="max-width: 50%; background-color: #bfe1b1; align-content: center">Edit</a>
                </div>
                <div class="row m-2 align-items-center">
                    <a href="${pageContext.request.contextPath}/StepIngredient/Update?id=${recipe.id}" class="btn btn-primary" style="max-width: 50%; background-color: #bfe1b1 ; align-content: center">Modifier les ingrédients et les étapes</a>
                </div>
            </div>
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
                <div class="col-lg-4  mb-1">
                        <img src="${ringredient.ingredientByIngId.photoUrl}" alt="${ringredient.ingredientByIngId.name}" class="card-img-top embed-responsive-item">
                        <p class="">${ringredient.quantity} ${ringredient.unit}</p>
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


    </div>
</div>



</body>
</html>
