<%-- 
    Document   : sliderImages
    Created on : Jan 4, 2017, 2:37:45 AM
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
        <div id="page-wrapper" >
            <div id="page-inner" >
                <div class="row" >
                    <div class="col-md-8" >
                        <div class="col-md-8" >
                            <div class="panel panel-default col-md-12">
                                <div class="panel-body">
                                    
                                    <div class="tab-pane" id="2a"> 
                                        <div style="margin-top: 5%" class="row">
                                            <!--<h1>Image Upload</h1>-->
                                            <form:form  method="POST" cssClass="form-horizontal" action="uploadsliderimagemulti" enctype="multipart/form-data"  >  
                                                <label class="control-label col-sm-3 " for="genderId">Şəkil əlavə edin </label>
                                                <div class="col-sm-8">
                                                    <input type="file"  class="filestyle"  style="margin-top: 8px;" id="imagefile" name="imagefile" multiple="multiple" accept="image/*" />
                                                </div> 
                                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
<!--                                                <input type="hidden" name="id" 	value="${product.PId}" />-->
                                                <input type="submit" style="margin-top: 8px;" value="Upload" class="btn-primary btn-sm pull-left"> 
                                            </form:form>
                                        </div>
                                        <div style="margin-top: 2%" class="row">
                                            <c:forEach items="${sliderImagesList}" var="imgs">
                                                <div class="col-sm-4 col-lg-4 col-md-4" style="width: 300px; height: 300px">
                                                    <img style="max-height: 300px;max-width: 300px;" img src="${pageContext.servletContext.contextPath}${imgs.imageName}"/>
                                                    <a href="<c:url value="/admin/slideradmin/${imgs.id}/delete"/>"  class="delete btn btn-danger"><em class="fa fa-trash"></em></a> 
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
    </body>
</html>
