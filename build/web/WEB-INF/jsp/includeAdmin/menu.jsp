<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./"><img src="assets/images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="./"><img src="assets/images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/bienvenue"/>"> <i class="menu-icon fa fa-dashboard"></i>Utilisateur</a>
                    </li>
                   
                    <li>
                        <a href="pageProjet"> <i class="menu-icon fa fa-dashboard"></i>Listes des Projets </a>
                    </li>
                    
                    <li>
                        <a href="diagramme"> <i class="menu-icon fa fa-dashboard"></i>Diagramme de gantt</a>
                    </li>
                    
                    <li>
                        <a href="occupation"> <i class="menu-icon fa fa-dashboard"></i>Temps d'occupation</a>
                    </li>
                    
                    <li>
                        <a href="tache"> <i class="menu-icon fa fa-dashboard"></i>Taches</a>
                    </li>
                    
                    <li>
                        <a href="devs"> <i class="menu-icon fa fa-dashboard"></i>Listes developpeurs</a>
                    </li>
                    
                    
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->