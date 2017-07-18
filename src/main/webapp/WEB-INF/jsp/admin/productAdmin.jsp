<%-- 
    Document   : productAdmin
    Created on : Nov 28, 2016, 2:43:10 AM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/productPagingTag.tld"%>
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
            <spring:url value="/productsadmin" var="productsadmin" />
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-2 pull-right">
                                        <a href="<c:url value="product/add"/>" role="button" class="btn btn-info  btn " aria-pressed="true"  >New Product</a>
                                    </div>
                                    <form:form id="headerSearchForm" action="productsadmin" modelAttribute="productsadmin" class="col-sm-3 col-md-3 col-lg-12"  method="GET">
                                        
                                        <div class="navbar-btn navbar-btn">

                                            <div class="col-sm-3 col-md-3 col-lg-3"> 
                                                <form:input path="title" type="text" class="form-control" id="title" placeholder="Enter Title"/>
                                            </div> 
                                            <div class="col-sm-3 col-md-3 col-lg-3"> 
                                                <form:input path="price" type="text" class="form-control" id="price" placeholder="Enter Price"/>
                                            </div>  
                                            <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                                <div  class="input-group date" id="datetimepicker1"> 
                                                    <form:input path="toDate" type="text" class="form-control" id="toDate"  />
                                                    <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                    </span>
                                                </div>
                                            </div> 
                                            <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                                <div  class="input-group date" id="datetimepicker2"> 
                                                    <form:input path="fromDate" type="text" class="form-control" id="fromDate"  />
                                                    <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                    </span>
                                                </div>
                                            </div> 

                                            <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                                <form:select id="keyValue" class="btn  btn active" path="categoryId.catId"> 
                                                    <form:option  value="0" label="Category"/>
                                                    <form:options items="${categoryList}" itemValue="catId" itemLabel="name" />
                                                </form:select>
                                            </div>

                                            <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                                <form:select id="keyValue" class="btn  btn active" path="genderId.genderId"> 
                                                    <form:option  value="0" label="Gender"/>
                                                    <form:options items="${genderList}" itemValue="genderId" itemLabel="type" />
                                                </form:select>
                                            </div> 

                                            <div class="col-sm-3 col-md-3 col-lg-3"> 
                                                <form:select id="keyValue" class="btn  btn active"  path="brandId.id"> 
                                                    <form:option  value="0" label="Brands"/>
                                                    <form:options items="${brandList}" itemValue="id" itemLabel="name" />
                                                </form:select>
                                            </div> 
                                            <div class="col-sm-3 col-md-3 col-lg-3 ">
                                                <button type="submit"  class="btn btn-primary">Search</button>
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
                                                <th>Title</th>
                                                <th>Price</th>
                                                <th>Insert Date</th>                                                
                                                <th>Brand</th>
                                                <th>Category</th>

                                                <th><em class="fa fa-cog "></em></th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${productsList}" var="pr">
                                            <tbody>
                                                <tr>
                                                    <td class="col-sm-1">${pr.PId }</td>
                                                    <td class="col-sm-2">${pr.title }</td>
                                                    <td class="col-sm-1">${pr.price }</td>
                                                    <td class="col-sm-3">${pr.insertDate }</td>
                                                    <td class="col-sm-1">${pr.brandId.name }</td>
                                                    <td class="col-sm-2">${pr.categoryId.name }</td>
                                                    <td class="col-sm-2" align="center">
                                                        <a href="<c:url value="editproduct/${pr.PId}"/>" class="btn btn-info"><em class="fa fa-pencil"></em></a>
                                                        <a href="<c:url value="product/${pr.PId}/delete"/>" class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                    </td>
                                                </tr>                  
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <div style="margin-left: 10px;margin-top: 10px;" class="panel"> 
                             
                              <tag:paginate max="15" offset="${offset}"  count="${count}" title="${title}" price="${price}" toDate="${toDate}"  fromDate="${fromDate}" catgs="${catgs}" brands="${brands}" gendertype="${gendertype}" uri="productsadmin"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                            </div>
                        </div>
                    </div>
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>

            </div>
        </div>
        <script  type="text/javascript">
            $(function () {
                $("#datetimepicker1").datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: false,
                    startDate: "01/01/2016"
                });
                $("#datetimepicker2").datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    todayBtn: false,
                    startDate: "01/01/2016"
                });
            });
        </script>
    </body>
</html>
