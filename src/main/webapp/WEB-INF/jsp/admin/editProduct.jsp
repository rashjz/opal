<%-- 
    Document   : editProduct
    Created on : Dec 6, 2016, 4:13:55 PM
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
        <title>Opal.az - Admin</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
      

    </head>
    <body>
        <jsp:include page="template/headerAdmin.jsp" />
        <jsp:include page="template/menuAdmin.jsp" />
        <spring:url value="/admin/editproduct" var="actionUrl"/>
        <spring:url value="/admin/productsadmin" var="action"/>

        <div id="page-wrapper" >
            <div id="page-inner" >
                <div class="row" >
                    <div class="col-md-8" >

                        <div class="panel panel-default col-md-12">
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
                                                <h1 class="col-sm-8 col-xs-push-1">Add Product</h1>
                                                <h5 class="col-sm-8 col-xs-push-1"></h5>

                                            </c:when>
                                            <c:otherwise>
                                                <h1 class="col-sm-8 col-xs-push-1">Update Product</h1>
                                                <h5 class="col-sm-8 col-xs-push-1"></h5>

                                            </c:otherwise>

                                        </c:choose>
                                        <div class="row ">
                                            <div class="col-md-12">

                                                <form:form class="form-horizontal"  method="POST" modelAttribute="product" action="${actionUrl}">
                                                    <form:hidden path="pId" />
                                                    <spring:bind path="title">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="title">Title:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="title" type="text" class="form-control" id="title"/>
                                                                <form:errors path="title" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>
                                                    <spring:bind path="description">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="description">Description:</label>
                                                            <div class="col-sm-8"> 

                                                                <form:textarea path="description" type="text" class="form-control" id="description" rows="9" cols="30" />
                                                                <form:errors path="description" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <spring:bind path="insertDate">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="insertDate">Insert Date:</label>
                                                            <div class="col-sm-8"> 
                                                                <div  class="input-group date" id="datetimepicker1"> 
                                                                    <form:input path="insertDate" type="text" class="form-control" id="insertDate"  />
                                                                    <form:errors path="insertDate" class="control-label" />
                                                                    <span class="input-group-addon">
                                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                                    </span>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </spring:bind>
                                                    <spring:bind path="price">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="phone">Price:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="price" type="text" class="form-control" id="price"  />
                                                                <form:errors path="price" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <spring:bind path="viewCount">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="viewCount">View:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="viewCount" type="text" class="form-control" id="viewCount"  />
                                                                <form:errors path="viewCount" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>
                                                    <spring:bind path="note">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="phone">Note:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="note" type="text" class="form-control" id="note"  />
                                                                <form:errors path="note" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>
                                                    <spring:bind path="categoryId.catId">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">
                                                            <label class="control-label col-sm-3 " for="categoryId.name">Category</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select id="categoryId.name" class="form-control" path="categoryId.catId">
                                                                    <%--<form:options value="0"  label="Select Category"></form:options>--%>
                                                                    <form:options  items="${categoryList}" itemValue="catId" itemLabel="name" />
                                                                </form:select>
                                                                <form:errors path="categoryId.name" class="control-label" />
                                                            </div>
                                                        </div>
                                                    </spring:bind> 
                                                    <spring:bind path="brandId.id">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="brandId.name">Brand:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select id="brandId.name" class="form-control" path="brandId.id">
                                                                    <%--<form:options value="0"  label="Select Brand"></form:options>--%>
                                                                    <form:options  items="${brandList}" itemValue="id" itemLabel="name" />
                                                                </form:select>
                                                                <form:errors path="brandId.id" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind> 
                                                    <spring:bind path="genderId.genderId">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="genderId">Cinsi</label>
                                                            <div class="col-sm-8"> 
                                                                <form:select id="genderId.type" class="form-control" path="genderId.genderId">
                                                                    <%--<form:options value="0"  label="Select Gender"></form:options>--%>
                                                                    <form:options  items="${genderList}" itemValue="genderId" itemLabel="type" />
                                                                </form:select>
                                                                <form:errors path="genderId.genderId" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind> 

                                                    <spring:bind path="status">
                                                        <div class=" form-group ${status.error ? 'has-error' : ''}">

                                                            <label class="control-label col-sm-3 " for="status">Status:</label>
                                                            <div class="col-sm-8"> 
                                                                <form:input path="status" type="text" class="form-control" id="status"  />
                                                                <form:errors path="status" class="control-label" />
                                                            </div>

                                                        </div>
                                                    </spring:bind>

                                                    <c:choose>
                                                        <c:when test="${product.PId==null}">

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
                                                    <a href="<c:url value="/admin/productimg/${imgs.detId}/${product.PId}/delete"/>"  class="delete btn btn-danger"><em class="fa fa-trash"></em></a> 
                                                </div>
                                            </c:forEach>
                                        </div>
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



        <script  type="text/javascript">
            $(function () {
                $("#datetimepicker1").datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: false,
                    startDate: "01/01/2016"
                });
            });
        </script>
        <!-- /. WRAPPER  -->

    </body>
</html>
