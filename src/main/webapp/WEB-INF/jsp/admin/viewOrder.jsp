<%-- 
    Document   : viewOrder
    Created on : Nov 17, 2016, 5:40:16 PM
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
                        <div class=" panel-info col-md-6 pull-left">
                            <div class="panel-heading">Order</div>
                            <div class="panel-body ">
                                <div class="row ">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="id">Id:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.id}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="productId">Product:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.productId.title}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="count">Count:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.count}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="insertDate">Insert Date:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.insertDate}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-sm-4 " for="statusId">Status:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.statusId.status}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>


                        <div class=" panel-info col-md-6 pull-right">
                            <div class="panel-heading ">User</div>
                            <div class="panel-body ">
                                <div class="row ">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="firstname">Adı:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.userId.firstname}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="lastname">Soyadı:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.userId.lastname}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="username">Login:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.userId.username}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="control-label col-sm-4 " for="phone">Telefon:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.userId.phone}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-sm-4 " for="genderId">Cinsi:</label>
                                            <div class="col-md-8"> 
                                                <input value="${order.userId.genderId.type}" type="text" class="form-control" id="timestmp"/>
                                            </div>
                                        </div>
                                    </div>

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
