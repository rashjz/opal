<%-- 
    Document   : editUser
    Created on : Nov 24, 2016, 10:06:43 PM
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
        <div id="wrapper">

            <jsp:include page="template/headerAdmin.jsp" />
            <jsp:include page="template/menuAdmin.jsp" />
            <spring:url value="/admin/edituser" var="actionUrl"/>
            <spring:url value="/admin/users" var="action"/>
            <div id="page-wrapper" >
                <div id="page-inner" >    
                    <div class="row" >
                        <div class="col-md-12" >
                            <div class="panel panel-default col-md-12">
                                <div class="panel-body">

                                    <c:if test="${not empty msg}">
                                        <div class="alert alert-${css} alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            <strong>${msg}</strong>
                                        </div>
                                    </c:if>        
                                    <div class="row ">
                                        <div class="col-md-10">

                                            <form:form class="form-horizontal"  method="POST" modelAttribute="user" action="${actionUrl}">
                                                <form:hidden path="genderId.genderId" />
                                                <form:hidden path="userId" />
                                                <form:hidden path="password" />
                                                <form:hidden path="note" />
                                                <form:hidden path="image" />
                                                <spring:bind path="username">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="username">Username:</label>
                                                        <div class="col-sm-6"> 
                                                            <form:input path="username" type="text" class="form-control" id="username"/>
                                                            <form:errors path="username" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="firstname">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="firstname">Name:</label>
                                                        <div class="col-sm-6"> 
                                                            <form:input path="firstname" type="text" class="form-control" id="firstname" />
                                                            <form:errors path="firstname" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="lastname">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="lastname">Surname:</label>
                                                        <div class="col-sm-6"> 
                                                            <form:input path="lastname" type="text" class="form-control" id="lastname"  />
                                                            <form:errors path="lastname" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="phone">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="phone">Phone:</label>
                                                        <div class="col-sm-6"> 
                                                            <form:input path="phone" type="text" class="form-control" id="phone"  />
                                                            <form:errors path="phone" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>


                                                <spring:bind path="genderId.type">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="genderId">Cinsi</label>
                                                        <div class="col-sm-6"> 
                                                            <form:select id="genderId.type" class="form-control" path="genderId.type">
                                                                <option value="1">Kisi</option>
                                                                <option value="2">Qadin</option>
                                                            </form:select>
                                                            <form:errors path="genderId.type" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind> 
                                                <spring:bind path="enabled">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="enabled">Status</label>
                                                        <div class="col-sm-6"> 
                                                            <form:select id="enabled" class="form-control" path="enabled">
                                                                <option value="1">Aktiv</option>
                                                                <option value="2">Deaktiv</option>
                                                            </form:select>
                                                            <form:errors path="enabled" class="control-label" />
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
