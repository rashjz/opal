<%-- 
    Document   : fagAdmin
    Created on : Nov 13, 2016, 1:05:40 AM
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
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col col-xs-6">
                                        <a href="<c:url value="faq/add"/>" role="button" class="btn btn-info  btn " aria-pressed="true"  >New Faq</a>
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
                                                <th>Question</th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${faqList}" var="ca">
                                            <tbody>
                                                <tr>
                                                    <td align="center">

                                                        <a href="<c:url value="editFaq/${ca.id}"/>" class="btn btn-info"><em class="fa fa-pencil"></em></a>
                                                        <a href="<c:url value="faq/${ca.id}/delete"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                    </td>
                                                    <td class="col-sm-1">${ca.id}</td>
                                                    <td class="col-sm-9">${ca.question}</td>
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
