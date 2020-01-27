<%@page import="model.Teammembrevue"%>
<%@page import="model.Teammembre"%>
<%@page import="model.Utilisateurs"%>
<%@page import="model.BaseModele"%>
<%@page import="model.Projets"%>
<%@page import="java.util.List"%>

<%
   Utilisateurs leader =(Utilisateurs) request.getAttribute("leader");
   List<BaseModele> listes = (List<BaseModele>) request.getAttribute("developpeur");
   List<BaseModele> users = (List<BaseModele>) request.getAttribute("users");
   Teammembrevue temp;
   Utilisateurs user;
%>

<div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Listes des membres du projet</h1>
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
                                            <th scope="col">Id membre</th>
                                            <th scope="col">Nom membre</th>
                                            <th scope="col">Role</th>
                                            <th scope="col">Details</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><% out.println(leader.getId()); %></td>
                                            <td><% out.println(leader.getNomutilisateur()); %></td>
                                            <td>Leader</td>
                                            <td>
                                                <a class="btn btn-warning mb-1" href="equipe?leader=<% out.println(leader.getId()); %>" >Details
                                            </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                                    
                        <div class="card">
                            <div class="card-header"><strong>Attribution des membres du projet</strong></div>
                                <div class="card-body card-block">
                                    <form method="POST" action="assignerUser">
                                    <div class="form-group">
                                        <label for="nom" class=" form-control-label">Nom utilisateur</label>
                                        <select name="iduser" type="text" id="iduser" class="form-control">
                                            <%
                                                for(int i = 0; i<users.size();i++){
                                                user = (Utilisateurs) users.get(i);
                                            %>
                                            <option value=<% user.getId(); %> ><% out.println(user.getNomutilisateur()); %></option>
                                            <%
                                            }
                                            %>    
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-info mb-1">Ajouter</button>
                                    </form>
                                </div>
                            </div>
                    </div> 
                  </div>
               </div>                
        </div>
            
            
            
            
            
            
            
            
            
            
            
