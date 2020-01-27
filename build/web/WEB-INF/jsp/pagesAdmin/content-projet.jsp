            
<%@page import="model.Projets"%>
<%@page import="model.Utilisateurs"%>
<%@page import="model.BaseModele"%>
<%@page import="java.util.List"%>
<%
   List<BaseModele> listes = (List<BaseModele>) request.getAttribute("projets");
   Projets temp;
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
                                            <th scope="col">Id du projet</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Manager</th>
                                            <th scope="col">DateDebut</th>
                                            <th scope="col">DateFin</th>
                                            <th scope="col">Diagramme</th>
                                            <th scope="col">Occupation développeurs</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(int i = 0; i<listes.size();i++){
                                                temp = (Projets) listes.get(i);
                                        %>
                                        <tr>
                                            <th scope="row"><a href="projet?idprojet=<% out.println(temp.getId()); %>"><% out.println(temp.getId()); %></a></th>
                                            <th scope="row"><% out.println(temp.getDescription()); %></th>
                                            <td><% out.println(temp.getIdmanager()); %></td>
                                            <td><% out.println(temp.getDatedebut()); %></td>
                                            <td><% out.println(temp.getDateFin()); %></td>
                                            <td><a class="btn btn-danger mb-1" href="diagramme?idprojet=<% out.println(temp.getId()); %>">Diagramme</a></td>
                                            <td><a class="btn btn-warning mb-1" href="occupation?idprojet=<% out.println(temp.getId()); %>">Occupation</a></td>
                                        </tr>
                                        <%
                                        }
                                        %>
                                      
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    