<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_head.jsp"/>
<body>
<header>
    <jsp:include page="_navbar.jsp"/>
</header>

<div class="container">

    <h1>Recette</h1>

    <form action="${pageContext.request.contextPath}/recipe/create?author=${sessionScope.user}" method="POST">
        <label class="form-label" for="name">Nom de votre recette : </label>
        <input id="name" name="name" class="form-control" type="text">

        <label class="form-label" for="type">Type de recette :  </label>
        <select name="type" id="type" class="form-select">
            <option value="" >- Veuillez selectionner -</option>
            <option value="entree">Entr&eacute;e</option>
            <option value="plat">Plat</option>
            <option value="dessert">Dessert</option>
        </select>

        <label class="form-label" for="description">Description de la recette : </label>
        <textarea id="description" name="description" class="form-control">
        </textarea>

        <label class="form-label" for="photoUrl">Photo de la recette</label>
        <input id="photoUrl" name="photoUrl" class="form-control" type="text">

        <label class="form-label" for="dificulty">Niveau de difficult&eacute; : </label>
        <select name="dificulty" id="dificulty" class="form-select">
            <option value="" >- Veuillez selectionner -</option>
            <option value="facile">Facile</option>
            <option value="intermediaire">Intermediaire</option>
            <option value="difficile">Difficile</option>
        </select>

        <label class="form-label" for="price">Cout de la recette : </label>
        <select name="price" id="price" class="form-select">
            <option value="" >- Veuillez selectionner -</option>
            <option value="faible">Faible</option>
            <option value="intermediaire">Intermediaire</option>
            <option value="couteux">Couteux</option>
        </select>

        <label class="form-label" for="prepTime">Temps de preparation : </label>
        <input id="prepTime"  class="form-control" name="prepTime" type="number" placeholder="Saisir une dur&eacute;e en minutes" min="0" max="180">

        <label class="form-label" for="restTime" >Temps de repos : </label>
        <input id="restTime" name="restTime" class="form-control" type="number" placeholder="Saisir une dur&eacute;e en minutes" min="0" max="180">

        <label class="form-label" for="cookTime">Temps de cuisson : </label>
        <input id="cookTime" name="cookTime" class="form-control" type="number" placeholder="Saisir une dur&eacute;e en minutes" min="0" max="180">

        <%--        author--%>
        <label hidden class="form-label" for="author"></label>
        <input hidden id="author" name="author" class="form-control" type="text" value="${authorId}">
        <%--        ingredient--%>

        <label class="form-label" for="${ingredient.id}">Ingredient(s) - selection multiple possible : </label>
        <select name="ingredient" id="${ingredient.id}" class="form-select" multiple>
            <c:if test="${ingredients != null}">
                <c:forEach items="${ingredients}" var="ingredient" >
                    <option value="${ingredient.id}">${ingredient.name}</option>
                </c:forEach>
            </c:if>
        </select>
        <c:if test="${ingredients != null}">
            <c:forEach items="${ingredients}" var="ingredient" >
                <p>Ingr&eacute;dient - ${ingredient.name}</p>
                <label for="${ingredient.name}Qte">Quantit&eacute; : </label>
                <input type="number" name="${ingredient.name}Qte" id="${ingredient.name}Qte" class="form-control">

                <label for="${ingredient.name}Unit">Unit&eacute; de mesure : </label>
                <select name="${ingredient.name}Unit" id="${ingredient.name}Unit" class="form-select">
                    <option value="grammes">gr</option>
                    <option value="centilitre">cl</option>
                </select>

            </c:forEach>
        </c:if>

        <button class="btn btn-warning" id="addIng">Cr&eacute;er un ingr&eacute;dient</button>

        <br>

        <%--        step--%>
        <label class="form-label" for="step">Etape(s)</label>
        <input type="text" id="step" name=step" class="form-control">

<%--        <select name="step" id="${step.id}" class="form-select">--%>
<%--            <c:if test="${steps != null}">--%>
<%--                <c:forEach items="${steps}" var="step" >--%>
<%--                    <option value="${step.name}">${step.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </c:if>--%>
<%--        </select>--%>


        <button type="submit" class="btn btn-success">Valider</button>
        <script>
            function addIng(e) {
                e.preventDefault();
                console.log("test")

            }
            document.getElementById("addIng").addEventListener("click", addIng)
        </script>
    </form>

</div>

</body>
</html>
