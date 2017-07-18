<%-- 
    Document   : login2
    Created on : Oct 28, 2016, 9:00:35 PM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Hesabım</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />



        <spring:url value="/updateprofile" var="updateprofile"/>
        <%--<spring:url value="/uploadimage" var="uploadimage"/>--%>

        <div style="margin-top: 2%" class="container"> 








            <!--for to get message on action-->
            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>

            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div  class="panel panel-info">
                        <div class="panel-body">
                            <form:form  method="POST"  action="uploadimage" enctype="multipart/form-data"  > 
          
                                <img src="http://opal.az${user.image}" 
                                     onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" 
                                     style="width: 250px;height: 250px;" alt="" class="img-rounded img-responsive" />

                                <input type="file" style="margin-top: 2px;" id="imagefile" name="imagefile" accept="image/*" />
                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
                                <input type="submit" style="margin-top: 2px;" value="Change" class="btn-primary btn-sm pull-left"> 
                            </form:form>
                        </div>
                    </div>
                </div>


                <div class="col-sm-6 col-md-8">
                    <div  class="panel panel-info">
                        <center> 
                            <img src="data:image/png;base64,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" style="width: 100px;height: 100px;border-radius: 50%"  alt="" class="img-rounded img-responsive" />
                        </center>



                        <form style="margin-top: 5%" method="post" action="${updateprofile}">
                            <div class="panel-body">

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-edit"></span>
                                        </span>
                                        <input type="text"  class="form-control"  value="${user.firstname}"  placeholder="First Name" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-edit"></span></span>
                                        <input type="text" class="form-control" value="${user.lastname}"  placeholder="Last Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                                        <input type="text" class="form-control" value="${user.phone}"  placeholder="Mobile" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>

                                        <select  class="form-control" class="form-control" value="${user.genderId.type}" >
                                            <option value="1">Kişi</option>
                                            <option value="2">Qadın</option>
                                        </select>
                                    </div>
                                </div>



                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                        <input type="text" class="form-control" value="${user.username}"  placeholder="Email" readonly="true" />
                                    </div>
                                </div> 
                                <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                                <button class="btn btn-lg btn-primary btn-block" type="submit">
                                    Save
                                </button>


                            </div>
                        </form>  
                    </div>
                </div>
            </div>


        </div>




        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
