<%-- 
    Document   : editProduct
    Created on : Jan 23, 2017, 4:46:01 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Product User</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">  
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />
        <spring:url value="/editproduct" var="actionUrl"/>
        <spring:url  value="${pageContext.request.contextPath}/product/add" var="action" />
        <div id="page-wrapper " style="margin: 0 auto " >
            <div id="page-inner" >
                <div class="row col-md-offset-2  "  >
                    <div class="col-md-8" >
                        <div style="margin-top: 10px;" class="panel panel-default col-md-12">
                            <div class="panel-body">
                                <ul  class="nav nav-pills">
                                    <li class="active">
                                        <a  href="#1a" data-toggle="tab">Product Details</a>
                                    </li>
                                    <li><a href="#2a" data-toggle="tab">Product Images</a>
                                    </li> 
                                </ul>
                                <div class="tab-content clearfix">
                                    <div class="tab-pane active" id="1a">

                                        <c:if test="${not empty msg}">
                                            <div class="alert alert-${css} alert-dismissible" role="alert">
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                                <strong>${msg}</strong>
                                            </div>
                                        </c:if>  
                                        <c:choose>
                                            <c:when test="${product.PId==0 || product.PId==null}">
                                                <h1 class="col-sm-12 col-xs-push-3">Elanın Əlavə edilməsi</h1>
                                                <h5 class="col-sm-12 col-xs-push-1"></h5>
                                            </c:when>
                                            <c:otherwise>
                                                <h1 class="col-sm-12 col-xs-push-3">Update Product</h1>
                                                <h5 class="col-sm-12 col-xs-push-1"></h5>

                                            </c:otherwise>

                                        </c:choose>
                                        <div class="row ">
                                            <div class="col-md-12">

                                                <form:form class="form-horizontal"  method="POST" modelAttribute="product" action="${actionUrl}">
                                                    <form:hidden path="pId" />

                                                    <spring:bind path="title">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="title">Başlıq:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="title" type="text" class="form-control" id="title"/>
                                                                <form:errors path="title" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>
                                                    <spring:bind path="description">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="description">Ətraflı:</label>
                                                            <div class="col-sm-8"> 

                                                                <form:textarea path="description" type="text" class="form-control" id="description" rows="9" cols="30" />
                                                                <form:errors path="description" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <spring:bind path="price">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="phone">Qiymət:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="price" type="text" class="form-control" id="price"  />
                                                                <form:errors path="price" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <spring:bind path="note">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="phone">Qeyd:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="note" type="text" class="form-control" id="note"  />
                                                                <form:errors path="note" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <spring:bind path="categoryId.catId">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">
                                                            <label class="control-label col-sm-3 " for="categoryId">Kateqoriya:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select id="categoryId" class="form-control" path="categoryId.catId">
                                                                    <%--<form:option value="NONE"  label="Kateqoriya seçimi"></form:option>--%>
                                                                    <form:options  items="${categoryList}" itemValue="catId" itemLabel="name" />
                                                                </form:select>
                                                                <form:errors path="categoryId.catId" class="control-label" />
                                                            </div>
                                                        </div>
                                                    </spring:bind> 

                                                    <spring:bind path="brandId.id">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="brandId">Brend:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select class="form-control" path="brandId.id">
                                                                    <%--<form:option value="NONE"  label="Brend seçimi"></form:option>--%>
                                                                    <form:options  items="${brandList}" itemValue="id" itemLabel="name" />
                                                                </form:select>
                                                                <form:errors path="brandId.id" class="control-label" />
                                                            </div> 
                                                        </div>
                                                    </spring:bind> 

                                                    <spring:bind path="genderId.genderId">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="genderId.genderId">Cins:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select id="genderId.type" class="form-control" path="genderId.genderId">
                                                                    <%--<form:option value="NONE"  label="Cinsi seçin"></form:option>--%>
                                                                    <form:options  items="${genderList}" itemValue="genderId" itemLabel="type" />
                                                                </form:select>
                                                                <form:errors path="genderId.genderId" class="control-label" />
                                                            </div> 
                                                        </div>
                                                    </spring:bind>   
                                                    <c:if test="${product.PId!=null}">

                                                        <spring:bind path="status">
                                                            <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                                <label class="control-label col-sm-3 " for="status">Status:</label>
                                                                <div class="col-sm-8"> 
                                                                    <form:input path="status" type="text" class="form-control" id="status"  />
                                                                    <form:errors path="status" class="control-label" />
                                                                </div> 
                                                            </div>
                                                        </spring:bind>
                                                    </c:if>
                                                    <c:choose>
                                                        <c:when test="${product.PId==null}">

                                                            <button type="submit" class="btn btn-primary pull-right">Add</button>

                                                        </c:when>

                                                        <c:otherwise>

                                                            <button type="submit" class="btn btn-primary pull-right">Update</button>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </form:form>  

                                                <form:form class="form-horizontal" method="Post"  action="${pageContext.request.contextPath}/product/add">
                                                    <div class="col col-xs-6 pull-right">
                                                        <button type="submit" class="btn btn-primary pull-right">Yeni Məhsul</button>
                                                    </div>
                                                </form:form>

                                            </div>
                                        </div>      
                                    </div>
                                    <!--end of product details tab-->
                                    <div class="tab-pane" id="2a"> 
                                        <div style="margin-top: 5%" class="row">
                                            <!--<h1>Image Upload</h1>-->
                                            <form:form  method="POST" cssClass="form-horizontal" action="uploadimagemulti" enctype="multipart/form-data"  >  
                                                <label class="control-label col-sm-3 " for="genderId">Şəkil əlavə edin </label>
                                                <div class="col-sm-8">
                                                    <input type="file"  class="filestyle"  style="margin-top: 8px;" id="imagefile" name="imagefile" multiple="multiple" accept="image/*" />
                                                </div> 
                                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
                                                <input type="hidden" name="id" 	value="${product.PId}" />
                                                <input type="submit" style="margin-top: 8px;" value="Upload" class="btn-primary btn-sm pull-left"> 
                                            </form:form>
                                        </div>
                                        <div style="margin-top: 2%" class="row">
                                            <c:forEach items="${product.productImageCollection}" var="imgs">
                                                <div class="col-sm-4 col-lg-4 col-md-4" style="width: 300px; height: 300px">
                                                    <img style="max-height: 300px;max-width: 300px;" img src="${pageContext.servletContext.contextPath}${imgs.imgName}"/>
                                                    <a href="<c:url value="/productimg/${imgs.detId}/${product.PId}/delete"/>"  class="delete btn btn-danger"><em class="fa fa-trash"></em></a> 
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" charset="UTF-8"></script>

    </body>
</html>
