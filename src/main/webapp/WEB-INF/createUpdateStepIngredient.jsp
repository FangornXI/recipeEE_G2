<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container" style="align-content: center;max-width: 40%; padding: 30px;">
    <div class="card">
        <div class="card-body text-center">
            <h5 class="card-title">${recipe.name}</h5>
            <p class="card-text">${recipe.description}</p>
        </div>
        <a href="${pageContext.request.contextPath}/recipe?id=${recipe.id}" class="btn btn-primary">Retour Recette</a>
    </div>

    <form action="${pageContext.request.contextPath}/StepIngredient/Update?type=ingr" method="post">
        <input hidden name="id" value="${recipe.id}">

        <label class="form-label" for="name">Name ingredient : </label>
        <input id="name" name="name" class="form-control" type="text">
        <label class="form-label" for="photoUrl">Picture ingredient : </label>
        <input id="photoUrl" name="photoUrl" class="form-control" type="text">

        <label class="form-label" for="quantity">Quantity ingredient : </label>
        <input id="quantity" name="quantity" class="form-control" type="number">

        <label class="form-label" for="unit">Unite ingredient : </label>
        <input id="unit" name="unit" class="form-control" type="text">

        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Add Ingredient</button>
    </form>

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

    <form action="${pageContext.request.contextPath}/StepIngredient/Update?type=step" method="post">
        <input hidden name="id" value="${recipe.id}">
        <input hidden name="stepsNumber" value="${stepsNumber}">
        <label class="form-label" for="text">Text step : </label>
        <input id="text" name="text" class="form-control" type="text">


        <button type="submit" class="btn btn-lg btn-primary btn-block m-3">Add Step</button>
    </form>

    <div class="container mb-3">
        <c:forEach items="${steps}" var="step">
            <p><strong>Etape ${step.stepNumber}</strong></p>
            <p> </p>
            <p>${step.text}</p>
        </c:forEach>
    </div>
</div>



</body>
</html>
