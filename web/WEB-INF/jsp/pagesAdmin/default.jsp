<%@page import="model.Utilisateurs"%>
<%@page import="model.BaseModele"%>
<%@page import="java.util.List"%>
<%
   List<BaseModele> listes = (List<BaseModele>) request.getAttribute("users");
   Utilisateurs temp;
%>

<div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Dashboard</h1>
                    </div>
                </div>
</div>
    
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                        <ol class="breadcrumb text-right">
                            <li class="active">Dashboard</li>
                        </ol>
                    </div>
                </div>
            </div>
</div>

 <div class="content mt-4">
            <div class="animated fadeIn">
                <div class="row">
                   
                    
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Listes des Utilisateurs</strong>
                            </div>
                            <div class="card-body">
                                
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Nom</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Modification</th>
                                            <th scope="col">Suppression</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(int i = 0; i<listes.size();i++){
                                                temp = (Utilisateurs) listes.get(i);
                                                String modal = "#mediumModal"+i;
                                                //out.println(modal);
                                        %>
                                        <tr>
                                            <th scope="row"><% out.println(temp.getId()); %></th>
                                            <td><% out.println(temp.getNomutilisateur()); %></td>
                                            <td><% out.println(temp.getEmail()); %></td>
                                            <td>
                                                <button type="button" class="btn btn-success mb-1" data-toggle="modal" data-target=<% out.println(modal); %>>Modifier</button>
                                            </td>
                                            <td>
                                                <a onclick="return(confirm('Voulez vous supprimer cette utilisateur'));" href="supprimerUser?iduser=<% out.println(temp.getId()); %>" class="btn btn-danger mb-1" >Supprimer</a>
                                            </td>
                                        </tr>
                                        <%
                                        }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header"><strong>Inserer Utilisateur</strong></div>
                                <div class="card-body card-block">
                                    <form method="POST" action="insererUser">
                                    <div class="form-group">
                                        <label for="nom" class=" form-control-label">Email</label>
                                        <input name="email" type="email" id="email" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="nom" class=" form-control-label">Nom Utilisateur</label>
                                        <input name="nom" type="text" id="nom" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="description" class=" form-control-label">Profil</label>
                                        <input id="profil" name="profil" type="number" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="description" class=" form-control-label">Mot de passe</label>
                                        <input id="mdp" name="mdp" type="text" class="form-control">
                                    </div>    
                                    <button type="submit" class="btn btn-info mb-1">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                    </div> 
                    </div>
                  </div>                
        </div>
    </div>
    <div class="content mt-3">
            <div class="animated">
                <%
                    for(int i = 0; i<listes.size();i++){
                        temp = (Utilisateurs) listes.get(i);
                        String modal = "mediumModal"+i;
                %>
                <div class="modal fade" id=<% out.println(modal); %> tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="mediumModalLabel">Modifier</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="updateUser" method="POST">
                                   <div class="col-lg-12">
                                        <div class="card">
                                            <div class="card-header"><strong>Formulaire</strong></div>
                                                <div class="card-body card-block">
                                                    <input name="identifiant" type="hidden" id="identifiant" value=<% out.println(temp.getId()); %> class="form-control">
                                                    <div class="form-group">
                                                        <label for="nom" class=" form-control-label">Email</label>
                                                        <input name="email" type="email" id="email" value="<% out.println(temp.getEmail()); %>" class="form-control">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="nom" class=" form-control-label">Nom Utilisateur</label>
                                                        <input name="nom" type="text" id="nom" value="<% out.println(temp.getNomutilisateur()); %>" class="form-control">
                                                    </div>
                                                    <button type="submit" class="btn btn-info mb-1">Modifier</button>
                                                </div>
                                            </div>
                                    </div>                                   
                                </form>
                            </div>
                            <div class="modal-footer">
                              
                            </div>
                        </div>
                    </div>
                </div>
                <%
                }
                %>
            </div>
        </div>   
            
            
            
            
            
            
            
            
            
            
            
            
