<%-- 
    Document   : categoryAdmin
    Created on : Nov 7, 2016, 11:25:08 AM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
            <div id="page-wrapper">
                <div id="page-inner">

                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col col-xs-6">
                                        <a href="<c:url value="category/add"/>" role="button" class="btn btn-info  btn " aria-pressed="true"  >New Category</a>
                                    </div>
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
                                                <th><em class="fa fa-cog "></em></th>
                                                <th class="hidden-xs">ID</th>
                                                <th>Name</th>
                                                <th>Note</th>
                                                <th>Insert Date</th>
                                                <th>status</th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${category}" var="ca">
                                            <tbody>
                                                <tr>
                                                    <td class="col-sm-2" align="center">
                                                        <!--<a href="<c:url value="viewCustomers/${cu.id}"/>" class="btn btn-info"><em class="fa fa-search"></em></a>-->
                                                        <a href="<c:url value="editCategory/${ca.catId}"/>" class="btn btn-info"><em class="fa fa-pencil"></em></a>
                                                        <a href="<c:url value="category/${ca.catId}/delete"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                    </td>
                                                    <td class="col-sm-1">${ca.catId }</td>
                                                    <td class="col-sm-1">${ca.name }</td>
                                                    <td class="col-sm-5">${ca.note }</td>
                                                    <td class="col-sm-3">${ca.insertDate}</td>
                                                    <td class="col-sm-1">${ca.status }</td>
                                                </tr>                  
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>
            </div>
        </div>
    </body>

</html>
