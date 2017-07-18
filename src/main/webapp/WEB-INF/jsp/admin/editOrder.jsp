<%-- 
    Document   : editOrder
    Created on : Nov 17, 2016, 8:32:43 PM
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
            <spring:url value="/admin/editOrder" var="actionUrl"/>
            <spring:url value="/admin/checkoutList" var="action"/>
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
                                        <c:when test="${faq.id==0 || faq.id==null}">
                                            <h1 class="col-sm-8 col-xs-push-0">Update Order</h1>
                                            <h5 class="col-sm-8 col-xs-push-0"></h5>

                                        </c:when>
                                    </c:choose>
                                    <div class="row">
                                        <div class="col-md-10">

                                            <form:form class="form-horizontal"  method="POST" modelAttribute="order" action="${actionUrl}">

                                                <form:hidden path="id" />
                                                <form:hidden path="productId.pId" />
                                                <form:hidden path="userId.userId" />

                                                <spring:bind path="productId.title">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="productId">Product:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="productId.title" type="text" readonly="true" class="form-control" id="productId" placeholder="Enter Product"/>
                                                            <form:errors path="productId.title" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="userId.firstname">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="firstname">Firstname:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="userId.firstname" type="text" readonly="true" class="form-control" id="firstname"  placeholder="Enter Firstname"/>
                                                            <form:errors path="userId.firstname" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="userId.lastname">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="lastname">Lastname:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="userId.lastname" type="text" readonly="true" class="form-control" id="lastname"  placeholder="Enter Lastname"/>
                                                            <form:errors path="userId.lastname" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="count">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="count">Count:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="count" type="text" readonly="true" class="form-control" id="count"  placeholder="Enter Count"/>
                                                            <form:errors path="count" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="insertDate">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="insertDate">Insert Date:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="insertDate" type="text" class="form-control" readonly="true" id="insertDate" />
                                                            <form:errors value="${order.insertDate}" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="statusId.id">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="statusId">Status</label>
                                                        <div class="col-sm-10"> 
                                                            <form:select id="status"  class="form-control" path="statusId.id">
                                                                <option value="1">İcrada</option>
                                                                <option value="2">Çatdırılıb</option>
                                                                <option value="3">Səbətdə</option>
                                                                <option value="4">Deaktiv</option>
                                                            </form:select>
                                                            <form:errors path="statusId.id" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>                                                                                                
                                                <button type="submit" class="btn btn-primary pull-right">Update</button>
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
