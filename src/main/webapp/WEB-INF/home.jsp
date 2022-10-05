<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<c:if test = "${sessionScope.user != null}" var="condition">
    <div class="container">
        <div class="row col-7 mx-auto">
            <form class="form-signin border border-black-50 p-2 rounded my-3" action="${pageContext.request.contextPath}/homepage" method="POST">
                <input hidden value="${histo}" name="histo">
                <p class="text-center fs-5">&#128071; Vous recherchez une recette? dites-nous en plus ! &#128071;</p>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="name" name="name" value="${name}">
                    <label for="name">Nom de la recette : </label>
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
                    <button class="btn btn-success btn-login text-uppercase fw-bold my-2" type="submit">Recherche</button>
                </div>
            </form>
        </div>
    </div>
</c:if>

    <div class="container">
        <c:if test="${sessionScope.user == null}">
            <div class="my-5 fs-4 text-center fst-italic">
                <p>Bienvenue sur note site de cuisine pour tous</p>
                <p>n'hesitez pas a vous creer un compte pour avoir acces a plus de fonctionnalites &#9997; &#9757;</p>
            </div>
        </c:if>


        <div class="row justify-content-center">
            <c:if test="${recipes != null}">
            <c:forEach items="${recipes}" var="recipe">
                <div class="card col-2 p-0 m-1" style="max-height: 300px">
                    <img src="${recipe.photoUrl}" class="card-img-top w-100" alt="${recipe.name}" style="max-height: 40%">
                    <div class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                        <p class="card-text">${recipe.description}</p>
                        <a href="${pageContext.request.contextPath}/recipe?id=${recipe.id}" class="btn btn-primary">View</a>
                    </div>
                </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</body>
</html>
