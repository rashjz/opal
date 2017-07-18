<%-- 
    Document   : headerAdmin
    Created on : Nov 7, 2016, 10:24:03 AM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        
        <!--<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >-->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" > 
        <link href="${pageContext.request.contextPath}/resources/css/style_1.css" rel="stylesheet" >  
          
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" /> 
        <!--<script src="{pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>--> 
        <!--<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" type="text/css" />-->
        <link href="${pageContext.request.contextPath}/resources/css/custom-styles.css" rel="stylesheet" />  
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'> 
        <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/index"><i class="fa fa-gear"></i> <strong>OPAL.AZ</strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-envelope-o">
                            <samp id="count" style="display: block; position: absolute;margin-top: -25px; margin-left: 14px;color: lightblue;">
                                ${messageListCount} </samp></i> 
                    </a>

                    
                    <ul class="dropdown-menu dropdown-messages">
                        <c:forEach items="${newMessageList}" var="msj">
                        <li>
                            <a href="${pageContext.request.contextPath}/userListMassage/${msj.userId.userId}/${msj.PId.PId}">
                                <div>
                                    <strong>${msj.userId.firstname} ${msj.userId.lastname}</strong>
                                    <span class="pull-right text-muted">
                                        <em>${msj.insertDate}</em>
                                    </span>
                                </div>
                                <div>${msj.message}</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        </c:forEach>
                       
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <samp id="count" style="display: block; position: absolute; margin-top: -32px; margin-left: 14px;color: lightblue;">${orderCount} </samp><i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <c:forEach items="${newOrderList}" var="order">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/checkoutList?statusId.id=5">
                                <div>
                                    <strong>${order.userId.firstname} ${order.userId.lastname}</strong>
                                    <span class="pull-right text-muted">
                                        <em>${order.insertDate}</em>
                                    </span>
                                </div>
                                <div>${order.count}</div>
                            </a>
                        </li>
                        </c:forEach>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/profile"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/profile"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>


    </body>
</html>
