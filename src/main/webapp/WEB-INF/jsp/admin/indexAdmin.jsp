<%-- 
    Document   : index
    Created on : Nov 6, 2016, 11:02:51 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Admin</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <div id="wrapper">

            <jsp:include page="template/headerAdmin.jsp" />
            <!--/. NAV TOP  -->
            <jsp:include page="template/menuAdmin.jsp" />
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper">
                <div id="page-inner">


                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="page-header">
                                Dashboard <small>Summary of your App</small>
                            </h1>
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Library</a></li>
                                <li class="active">Data</li>
                            </ol>
                        </div>
                    </div>
                    <!-- /. ROW  -->

                    <div class="row">
                        <div class="col-md-3 col-sm-12 col-xs-12">
                            <div class="panel panel-primary text-center no-boder bg-color-green green">
                                <div class="panel-left pull-left green">
                                    <i class="fa fa-eye fa-5x"></i>

                                </div>
                                <div class="panel-right">
                                    <h3>8,457</h3>
                                    <strong> Daily Visits</strong>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-12 col-xs-12">
                            <div class="panel panel-primary text-center no-boder bg-color-blue">
                                <div class="panel-left pull-left blue">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>

                                <div class="panel-right">
                                    <h3>52,160 </h3>
                                    <strong> Sales</strong>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-12 col-xs-12">
                            <div class="panel panel-primary text-center no-boder bg-color-red">
                                <div class="panel-left pull-left red">
                                    <i class="fa fa fa-comments fa-5x"></i>

                                </div>
                                <div class="panel-right">
                                    <h3>15,823 </h3>
                                    <strong> Comments </strong>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-12 col-xs-12">
                            <div class="panel panel-primary text-center no-boder bg-color-brown">
                                <div class="panel-left pull-left brown">
                                    <i class="fa fa-users fa-5x"></i>

                                </div>
                                <div class="panel-right">
                                    <h3>36,752 </h3>
                                    <strong>No. of Visits</strong>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-6 col-md-3">
                            <div class="panel panel-default">
                                <div class="panel-body easypiechart-panel">
                                    <h4>Customers</h4>
                                    <div class="easypiechart" id="easypiechart-blue" data-percent="82" ><span class="percent">82%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <div class="panel panel-default">
                                <div class="panel-body easypiechart-panel">
                                    <h4>Sales</h4>
                                    <div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <div class="panel panel-default">
                                <div class="panel-body easypiechart-panel">
                                    <h4>Profits</h4>
                                    <div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <div class="panel panel-default">
                                <div class="panel-body easypiechart-panel">
                                    <h4>No. of Visits</h4>
                                    <div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--/.row-->
                    <div class="row">
                        <div class="col-md-12">

                        </div>		
                    </div> 	
                    <!-- /. ROW  -->
                    <div class="row">
                        <div class="col-md-4 col-sm-12 col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Tasks Panel
                                </div>
                                <div class="panel-body">
                                    <div class="list-group">

                                        <a href="#" class="list-group-item">
                                            <span class="badge">7 minutes ago</span>
                                            <i class="fa fa-fw fa-comment"></i> Commented on a post
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <span class="badge">16 minutes ago</span>
                                            <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <span class="badge">36 minutes ago</span>
                                            <i class="fa fa-fw fa-globe"></i> Invoice 653 has paid
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <span class="badge">1 hour ago</span>
                                            <i class="fa fa-fw fa-user"></i> A new user has been added
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <span class="badge">1.23 hour ago</span>
                                            <i class="fa fa-fw fa-user"></i> A new user has added
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <span class="badge">yesterday</span>
                                            <i class="fa fa-fw fa-globe"></i> Saved the world
                                        </a>
                                    </div>
                                    <div class="text-right">
                                        <a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <!-- /. ROW  -->
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>

                <!-- /. PAGE WRAPPER  -->
            </div>
        </body>
</html>
