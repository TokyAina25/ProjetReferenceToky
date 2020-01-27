<%@page import="java.util.List"%>
<%@page import="model.OccupationDeveloppeur"%>
<%
    List<OccupationDeveloppeur> listes = (List<OccupationDeveloppeur>) request.getAttribute("occupation");
%>

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
                                            <th scope="col">Developpeur</th>
                                            <th scope="col">Taux</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(int i = 0; i<listes.size();i++){
                                        %>
                                        <tr>
                                           
                                            <td><% out.println(listes.get(i).getProjet()); %></td>
                                            <td><% out.println(listes.get(i).getDeveloppeur()); %></td>
                                            <td><% out.println(listes.get(i).getTaux()*100); %>%</td>
                                        </tr>
                                        <%
                                        }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>