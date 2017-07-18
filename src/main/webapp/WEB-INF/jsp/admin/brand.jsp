<%-- 
    Document   : brand
    Created on : Nov 10, 2016, 2:28:52 PM
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
        <title>Brand</title>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="template/headerAdmin.jsp" />
            <jsp:include page="template/menuAdmin.jsp" />
            <spring:url value="/brands" var="brands" />
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                            <div class="panel-heading">
                                <div class="row">
                                    <form:form id="headerSearchForm" action="brands" modelAttribute="brands" class="col-sm-3 col-md-3 col-lg-12"  method="GET">
                                        <div class="navbar-btn navbar-btn">
                                            <spring:bind path="name">   
                                                <div class="col-sm-3 col-md-3 col-lg-3"> 
                                                    <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name"/>
                                                </div> 
                                            </spring:bind> 
                                            <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                                <button type="submit"  class="btn btn-primary">Search</button>
                                            </div>
                                            <div class="col col-xs-6">
                                                <a href="<c:url value="brand/add"/>" role="button" class="btn btn-info  btn " aria-pressed="true"  >New Brand</a>
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
                                                <th>Name</th>
                                                <th><em class="fa fa-cog "></em></th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${brandsList}" var="ca">
                                            <tbody>
                                                <tr>

                                                    <td class="col-sm-1">${ca.id }</td>
                                                    <td class="col-sm-9">${ca.name }</td>
                                                    <td class="col-sm-2" align="center">
                                                        <a href="<c:url value="editBrand/${ca.id}"/>" class="btn btn-info"><em class="fa fa-pencil"></em></a>
                                                        <a href="<c:url value="brand/${ca.id}/delete"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                    </td>
                                                </tr>                  
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <div style="margin-left: 10px;margin-top: 10px;" class="panel"> 
                                <tag:paginate max="15" offset="${offset}"  count="${count}" uri="brands"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                            </div>
                        </div>
                    </div>
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>
            </div>
        </div>
    </body>
</html>
