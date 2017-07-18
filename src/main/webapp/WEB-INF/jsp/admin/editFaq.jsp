<%-- 
    Document   : editFaq
    Created on : Nov 13, 2016, 1:05:53 AM
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
            <spring:url value="/admin/editFaq" var="actionUrl"/>
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
                                            <h1 class="col-sm-8 col-xs-push-0">Update Faq</h1>
                                            <h5 class="col-sm-8 col-xs-push-0"></h5>

                                        </c:when>

                                    </c:choose>

                                    <div class="row ">
                                        <div class="col-md-10">

                                            <form:form class="form-horizontal"  method="POST" modelAttribute="faq" action="${actionUrl}">

                                                <form:hidden path="id" />
                                                <spring:bind path="question">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="question">Question:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:input path="question" type="text" class="form-control" id="question" placeholder="Enter Question"/>
                                                            <form:errors path="question" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="answer">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="answer">Answer:</label>
                                                        <div class="col-sm-10"> 
                                                            <form:textarea path="answer" type="text" class="form-control" id="answer" rows="9" cols="30" placeholder="Enter Answer"/>
                                                            <form:errors path="answer" class="control-label" />
                                                        </div>

                                                    </div>
                                                </spring:bind>
                                                <spring:bind path="status">
                                                    <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                        <label class="control-label col-sm-2 " for="status">Status</label>
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
                                                    <c:when test="${faq.id==null}">

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