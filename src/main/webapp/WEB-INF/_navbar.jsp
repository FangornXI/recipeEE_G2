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
                <li class="nav-item">
                    <a class="nav-link" href="#">Se connecter</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/addUser">S'inscrire</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Se d&eacute;connecter</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ajouter une recette</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Recette al&eacute;atoire</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Edit profil</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#"></a>Liste recettes deja cuisin&eacute;es</li>
                        <li><a class="dropdown-item" href="#">tarte aux pommes</a></li>
                    </ul>
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
                        <a class="nav-link" href="#">Recette al&eacute;atoire</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Profil</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/Update">Edit profil</a></li>
                            <li><a class="dropdown-item" href="#"></a>Historique recettes</li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Se d&eacute;connecter</a>
                    </li>
                </c:if>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Recherche par mot clé" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            
        </div>
    </div>
</nav>
