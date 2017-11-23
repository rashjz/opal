<%-- 
    Document   : orderAdmin
    Created on : Nov 17, 2016, 12:55:27 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/OrderPagingTag"%>
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
            <jsp:include page="template/menuAdmin.jsp" />
                 <spring:url value="/checkoutList" var="orderadmin" />
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                       <div class="panel-heading ">
                                <div class="row ">
                                    <form:form id="headerSearchForm" action="checkoutList" modelAttribute="order" class="col-sm-3 col-md-3 col-lg-12"  method="GET">
                                        <div class="navbar-btn navbar-btn">
                                            
                                            <form:hidden path="statusId.Id"/>
                                                <div class="col-sm-4 col-md-4 col-lg-4"> 
                                                    <form:input path="userId.username" type="text" class="form-control" id="userId.username" placeholder="Username"/>
                                                </div>                                                                                                                               
                                                <div class="col-sm-4 col-md-4 col-lg-4"> 
                                                    <form:input path="productId.title" type="text" class="form-control" id="productId.title" placeholder="Enter Product"/>
                                                </div>                                                                                        
                                                <div class="col-sm-4 col-md-4 col-lg-4"> 
                                                    <form:input path="count" type="text" class="form-control" id="count" placeholder="Enter Count"/>
                                                </div>                                                                                     
                                                <div class="col-sm-4 col-md-4 col-lg-4"> 
                                                    <div  class="input-group date" id="datetimepicker1"> 
                                                        <form:input path="toDate" type="text" class="form-control" id="toDate"  />
                                                        <span class="input-group-addon">
                                                            <span class="glyphicon glyphicon-calendar"></span>
                                                        </span>
                                                    </div>
                                                </div>                                                                                     
                                                <div class="col-sm-4 col-md-4 col-lg-4 "> 
                                                    <div  class="input-group date" id="datetimepicker2"> 
                                                        <form:input path="fromDate" type="text" class="form-control" id="fromDate"  />
                                                        <span class="input-group-addon">
                                                            <span class="glyphicon glyphicon-calendar"></span>
                                                        </span>
                                                    </div>
                                                </div>                                                                                      
                                            <div class="col-sm-4 col-md-4 col-lg-4 pull-right"> 

                                                <button type="submit"  class="btn btn-primary pull-right">Search</button>
                                            </div>

                                        </div>
                                    </form:form>
                                </div>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty msg}">
                                    <div class="alert alert-${css} alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <strong>${msg}</strong>
                                    </div>
                                </c:if> 
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-list">
                                        <thead>
                                            <tr>

                                                <th class="hidden-xs">ID</th>
                                                <th>Product</th>
                                                <th>User</th>
                                                <th>Count</th>
                                                <th>Insert Date </th>
                                                <th>Status</th>
                                                <th><em class="fa fa-cog "></em></th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${orderList}" var="ord">
                                            <tbody>
                                                <tr>

                                                    <td class="col-sm-1">${ord.id }</td>
                                                    <td class="col-sm-2">${ord.productId.title }</td>
                                                    <td class="col-sm-2">${ord.userId.username} </td>
                                                    <td class="col-sm-1">${ord.count }</td>
                                                    <td class="col-sm-2">${ord.insertDate }</td>
                                                    <td class="col-sm-1">${ord.statusId.status }</td>
                                                    <td class="col-sm-2" align="center">
                                                        <a href="<c:url value="viewOrder/${ord.id}"/>" class="btn btn-info"><em class="fa fa-search"></em></a>
                                                        <a href="<c:url value="editOrder/${ord.id}"/>" class="btn btn-success"><em class="fa fa-pencil"></em></a>
                                                        <a href="<c:url value="order/${ord.id}/delete"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                    </td>
                                                </tr>                  
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <div style="margin-left: 10px;margin-top: 10px;" class="panel"> 
                                <tag:paginate max="15" offset="${offset}" count="${count}" statusId="${statusId}"   orderUsername="${orderUsername}"   toDate="${toDate}"  fromDate="${fromDate}"  uri="checkoutList" keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                            </div>
                        </div>
                    </div>
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>
            </div>
        </div>
         <script  type="text/javascript">
            $(function () {
                $("#datetimepicker1").datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: false,
                    startDate: "01/01/2016"
                });
                $("#datetimepicker2").datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: false,
                    startDate: "01/01/2016"
                });
            });
        </script>        
    </body>
</html>
