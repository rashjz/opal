<%-- 
    Document   : editCategoryAdmin
    Created on : Nov 8, 2016, 11:49:24 AM
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
        <title>Opal.az - Admin</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <div id="wrapper" style="height: 100%">

            <jsp:include page="template/headerAdmin.jsp" />
            <jsp:include page="template/menuAdmin.jsp" />
            <spring:url value="/admin/editCategory" var="actionUrl"/>
            <spring:url value="/admin/categoryAdmin" var="action"/>
            <div id="page-wrapper" >
                <div id="page-inner" >   
                    <div class="row" >
                        <div class="col-md-12" >
                            <div class="panel panel-default col-md-12">
                                <div class="panel-body">
                                    <c:if test="${not empty msg}">
                                        <div class="col-sm-5 alert alert-${css} alert-dismissible " role="alert" >
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            <strong>${msg}</strong>
                                        </div>
                                    </c:if> 
                                    <c:choose>
                                        <c:when test="${category.catId==0 || category.catId==null}">
                                            <h1 class="col-sm-8 col-xs-push-1">Add Category</h1>
                                            <h5 class="col-sm-8 col-xs-push-1"></h5>

                                        </c:when>
                                        <c:otherwise>
                                            <h1 class="col-sm-8 col-xs-push-1">Update Category</h1>
                                            <h5 class="col-sm-8 col-xs-push-1"></h5>

                                        </c:otherwise>

                                    </c:choose>
                                    <div class="row ">
                                        <div class="col-md-10">

                                            <form:form class="form-horizontal"  method="POST" modelAttribute="category" action="${actionUrl}">

                                                <form:hidden path="catId" />
                                                <spring:bind path="name">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="name">Name:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name"/>
                                                            <form:errors path="name" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="note">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label  col-sm-2 " for="Note">Note:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="note" type="text" class="form-control" id="note" placeholder="Enter Note"/>
                                                            <form:errors path="note" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>  
                                                <spring:bind path="insertDate">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label  col-sm-2 " for="insertDate">Insert Date:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="insertDate" type="text" class="form-control" id="insertDate" disabled="true" placeholder="Enter Note"/>
                                                            <form:errors path="insertDate" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>   
                                                <spring:bind path="status">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label  col-sm-2 " for="status">Status:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:select id="status" class="form-control" path="status">
                                                                <option value="1">Aktiv</option>
                                                                <option value="2">Deaktiv</option>

                                                            </form:select>
                                                            <form:errors path="status" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>   
                                                <c:choose>
                                                    <c:when test="${category.catId==null}">

                                                        <button type="submit" class="btn btn-primary pull-right">Add</button>

                                                    </c:when>

                                                    <c:otherwise>

                                                        <button type="submit" class="btn btn-primary pull-right">Update</button>

                                                    </c:otherwise>
                                                </c:choose>

                                            </form:form>  
                                            <form:form class="form-horizontal"  method="GET" action="${action}">
                                                <div class="col col-xs-6 pull-right">
                                                    <button type="submit" class="btn btn-primary pull-right"> Back</button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                     <jsp:include page="template/footerAdmin.jsp" />
                </div>
                <!-- /. PAGE INNER  -->
            </div>
            <!-- /. WRAPPER  -->
        </div>

    </body>
</html>