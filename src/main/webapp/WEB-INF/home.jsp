<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<c:if test = "${sessionScope.user != null}" var="condition">
    <div class="container">
        <form class="form-signin" action="${pageContext.request.contextPath}/homepage" method="POST">
            <input hidden value="${histo}" name="histo">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="name" name="name" value="${name}">
                <label for="name">Name</label>
            </div>
            <label class="form-label" for="type">Type de recette :  </label>
            <select name="type" id="type" class="form-select">
                <option value="">- Veuillez selectionner -</option>
                <option value="entree" <c:if test="${type =='entree'}">selected="selected"</c:if>>Entr&eacute;e</option>
                <option value="plat" <c:if test="${type == 'plat'}">selected="selected"</c:if>>Plat</option>
                <option value="dessert" <c:if test="${type == 'dessert'}">selected="selected"</c:if>>Dessert</option>
            </select>

            <label class="form-label" for="dificulty">Niveau de difficult&eacute; : </label>
            <select name="dificulty" id="dificulty" class="form-select">
                <option value="">- Veuillez selectionner -</option>
                <option value="facile" <c:if test="${dificulty == 'facile'}">selected="selected"</c:if>>Facile</option>
                <option value="intermediaire" <c:if test="${dificulty == 'intermediaire'}">selected="selected"</c:if>>Intermediaire</option>
                <option value="difficile" <c:if test="${dificulty == 'difficile'}">selected="selected"</c:if>>Difficile</option>
            </select>

            <label class="form-label" for="price">Cout de la recette : </label>
            <select name="price" id="price" class="form-select">
                <option value="">- Veuillez selectionner -</option>
                <option value="faible" <c:if test="${price == 'faible'}">selected="selected"</c:if>>Faible</option>
                <option value="intermediaire" <c:if test="${price == 'intermediaire'}">selected="selected"</c:if>>Intermediaire</option>
                <option value="couteux" <c:if test="${price == 'couteux'}">selected="selected"</c:if>>Couteux</option>
            </select>

            <div class="d-grid">
                <button class="btn btn-success btn-login text-uppercase fw-bold" type="submit">Recherche</button>
            </div>
        </form>
    </div>
</c:if>

    <div class="container">
        <div class="row justify-content-center">
            <c:if test="${recipes != null}">
            <c:forEach items="${recipes}" var="recipe">
                <div class="card col-3 p-0 m-1">
                    <img src="${recipe.photoUrl}" class="card-img-top w-100" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                        <p class="card-text">${recipe.description}</p>
                        <a href=${pageContext.request.contextPath}/recipe?id=${recipe.id}" class="btn btn-primary">View</a>
                    </div>
                </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</body>
</html>
