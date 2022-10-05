<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <img src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/100.png" alt="logo">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/homepage">Home</a>
                </li>
                <c:if test = "${sessionScope.user == null}" var="condition">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/Create">S'inscrire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Se connecter</a>
                    </li>
                </c:if>
                <c:if test="${!condition}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ajouter une recette</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/reciperand">Recette al&eacute;atoire</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Profil</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/Update">Edit profil</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/homepage?histo=true">Historique recettes</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Se d&eacute;connecter</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
