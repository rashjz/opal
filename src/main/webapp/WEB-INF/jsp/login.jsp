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
        <title>Opal.az - Əl İşləri</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />



        <div class="login">
            <div class="container">
                <div class="login-grids">
                    <div class="col-md-6 log">
                        <h3>Login</h3>
                        <div class="strip"></div>
<!--                        <p>Salam, davam etmək üçün aşağıdakı daxil edin.</p>
                        <p>If you have previously Login with us, <a href="#">Click Here</a></p>-->                        <p>If you have previously Login with us, <a href="#">Click Here</a></p>

                        <spring:url var="loginUrl" value="/login" />
                      
                        <form id="loginform" action="${loginUrl}" method="post"  role="form">
                            <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>

                            <h5>İstifadəçi Adı:</h5>  
                            <input id="username" type="text" class="form-control" name="ssoId" value="" placeholder="username or email">                                        
                            <h5>Şifrə:</h5>
                            <input id="password" type="password" class="form-control" name="password" placeholder="password">

                            <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                            <div class="checkbox">
                                <label>
                                    <input id="login-remember" type="checkbox" name="remember-me" value="1"> Remember me
                                </label>
                            </div>

                            <input type="submit" value="Giriş">
                        </form>
                        <a href="#">Forgot Password ?</a>
                    </div>
                    <div class="col-md-6 login-right">
                        <h3>Yeni Qeydiyyat</h3>
                        <div class="strip"></div>
                        <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                        <a href="register" class="button">Qeydiyyat</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>



        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
