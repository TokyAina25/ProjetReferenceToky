<%-- 
    Document   : home
    Created on : 22 janv. 2019, 08:23:26
    Author     : OTME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>E-Project</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/vendors/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendors/selectFX/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/vendors/jqvmap/dist/jqvmap.min.css">
    <script type="text/javascript" src="assets/js/loader.js"></script>
    <script src="assets/js/html2pdf.bundle.min.js"></script>
    <link rel="stylesheet" href="assets/css/style.css">
   
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>

<body>

    <%@include file="includeAdmin/menu.jsp" %>

    <div id="right-panel" class="right-panel">

        <%@include file="includeAdmin/header.jsp" %>
        <%
                       try{
                            String contenue = request.getParameter("contenue");                       
                            if(request.getParameter("contenue") == null){ %>
                             <jsp:include page="pagesAdmin/default.jsp" flush = 'true'></jsp:include>
                         <% }if(contenue != null){
                         %>
                        <jsp:include page='<%="pagesAdmin/content-" + contenue %>' />

                         <% } 
                         }catch(Exception ex){
                           out.println(ex.getMessage());
                         }
                    %>
        
    </div>

    <script src="assets/vendors/jquery/dist/jquery.min.js"></script>
    <script src="assets/vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="assets/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>


    <script src="assets/vendors/chart.js/dist/Chart.bundle.min.js"></script>
    <script src="assets/js/dashboard.js"></script>
    <script src="assets/js/widgets.js"></script>
    <script src="assets/vendors/jqvmap/dist/jquery.vmap.min.js"></script>
    <script src="assets/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <script src="assets/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script>
        (function($) {
            "use strict";

            jQuery('#vmap').vectorMap({
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: ['#1de9b6', '#03a9f5'],
                normalizeFunction: 'polynomial'
            });
        })(jQuery);
    </script>

</body>

</html>



