<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<input hidden name="idRecipe" value="${recipe.id}">

<div class="card" style="max-width: 40%;">
    <img class="card-img-top" src="${recipe.photoUrl}" alt="${recipe.name}">
    <div class="card-body text-center">
        <h5 class="card-title">${recipe.name}</h5>
        <p class="card-text">${recipe.description}</p>
    </div>

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
        <c:forEach items="recipeIngredients" var="ringredient">
            <div class="col-lg3 mb-2">
                <img src="${ringredient.ingredientByIngId.photoUrl}" alt="${ringredient.ingredientByIngId.name}">
                <p>${ringredient.quantity} ${ringredient.unit}</p>
            </div>
        </c:forEach>
    </div>

    <div class="container mb-3">
        <c:forEach items="steps" var="step">
            <p><strong>Etape ${step.stepNumber}</strong></p>
            <p> </p>
            <p>${step.text}</p>
        </c:forEach>
    </div>

    <div class="card-body mb-3">
        <c:forEach items="comments" var="comment">
            <p>commentaire laissé par <a href="#">${comment.userByUserId.name}</a></p>
            <p><strong>Note ${comment.rating}/5</strong></p>
            <p> </p>
            <div class="container mb-3">
                <p>${step.text}</p>
            </div>
        </c:forEach>
    </div>
</div>



</body>
</html>
