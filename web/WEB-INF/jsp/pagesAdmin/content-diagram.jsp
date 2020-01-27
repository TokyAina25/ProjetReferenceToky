<%@page import="model.Taches"%>
<%@page import="dao.Generaliser"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Diagramme"%>
<%@page import="java.util.List"%>
<%@page import="model.BaseModele"%>
<%
    List<BaseModele> listes =(List<BaseModele>) request.getAttribute("diagramme");
    Generaliser general = new Generaliser();
    Diagramme diagramme;
%>
 
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 
 <script type="text/javascript">
     
    google.charts.load('current', {'packages':['gantt']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Task ID');
      data.addColumn('string', 'Task Name');
      data.addColumn('string', 'Resource');
      data.addColumn('date', 'Start Date');
      data.addColumn('date', 'End Date');
      data.addColumn('number', 'Duration');
      data.addColumn('number', 'Percent Complete');
      data.addColumn('string', 'Dependencies');

      data.addRows([
        <%
            int taille = listes.size();
            for(int i=0;i<taille-1;i++){
                diagramme = (Diagramme) listes.get(i);
                //BaseModele base = general.find(new Taches(), "id="+diagramme.getId(), 0, 10).get(i);
                //Taches tache = (Taches) base;
        %>
            ['Equipe <%=i%>', 'Tache <%=diagramme.getId()%>', 'spring',
             new Date(<%=new SimpleDateFormat("yyyy").format(diagramme.getDatedebut()) %>,
                  <%=new SimpleDateFormat("MM").format(diagramme.getDatedebut()) %>,
                  <%=new SimpleDateFormat("dd").format(diagramme.getDatedebut()) %>),
                    new Date(<%=new SimpleDateFormat("yyyy").format(diagramme.getDatefin()) %>,
                    <%=new SimpleDateFormat("MM").format(diagramme.getDatefin()) %>,
                    <%=new SimpleDateFormat("dd").format(diagramme.getDatefin()) %>), 
                    null, <% out.println(diagramme.getTaux()); %>, null],
        <%
        }
        diagramme =(Diagramme) listes.get(listes.size()-1);
        %>
        ['Equipe <%=listes.size()-1%>', 'Tache <%=diagramme.getId()%>', 'spring',
             new Date(<%=new SimpleDateFormat("yyyy").format(diagramme.getDatedebut()) %>,
                  <%=new SimpleDateFormat("MM").format(diagramme.getDatedebut()) %>,
                  <%=new SimpleDateFormat("dd").format(diagramme.getDatedebut()) %>),
                    new Date(<%=new SimpleDateFormat("yyyy").format(diagramme.getDatefin()) %>,
                    <%=new SimpleDateFormat("MM").format(diagramme.getDatefin()) %>,
                    <%=new SimpleDateFormat("dd").format(diagramme.getDatefin()) %>), 
                    null, <% out.println(diagramme.getTaux()); %>, null]
        
      ]);

      var options = {
        height: 400,
        gantt: {
          trackHeight: 30
        }
      };

      var chart = new google.visualization.Gantt(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
  </script>
  <script>
    function generatePDF() {
      // Choose the element that our invoice is rendered in.
      const element = document.getElementById("invoice");
      // Choose the element and save the PDF for our user.
      html2pdf().from(element).save();
    }
  </script>
  <button onclick="generatePDF()">Download as PDF</button>
    <div id="invoice">
        <h4>Diagramme de gantt des taches en cours</h4>
      <div class="row">
          <div class="content mt-8">
              <div class="col-lg-6">
                  <div class="card">
                     <div id="chart_div"></div>
                  </div>

              </div>   
          </div>
      </div>
    </div>
