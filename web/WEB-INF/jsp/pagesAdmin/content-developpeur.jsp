            
<%@page import="model.Developpeur"%>
<%@page import="model.Projets"%>
<%@page import="model.Utilisateurs"%>
<%@page import="model.BaseModele"%>
<%@page import="java.util.List"%>
<%
   List<BaseModele> listes = (List<BaseModele>) request.getAttribute("developpeur");
   Developpeur temp;
%>

<div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Tableau</h1>
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
                                <strong class="card-title">Listes des projets en cours</strong>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id developpeur</th>
                                            <th scope="col">Nom</th>
                                            <th scope="col">Email</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(int i = 0; i<listes.size();i++){
                                                temp = (Developpeur) listes.get(i);
                                        %>
                                        <tr>
                                            <th scope="row"><a href="occupationdev?iddev=<% out.println(temp.getId()); %>"><% out.println(temp.getId()); %></a></th>
                                            <th scope="row"><% out.println(temp.getNomutilisateur()); %></th>
                                            <td><% out.println(temp.getEmail()); %></td>   
                                        </tr>
                                        <%
                                        }
                                        %>
                                      
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    