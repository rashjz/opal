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
        <title>Opal.az - Qeydiyyat</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
        
        <!--        <script type="text/javascript" src="//code.jquery.com/jquery-1.12.0.min.js"></script>-->
        <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>

    </head>
    <body> 

        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />


        <%-- Bax burda bitir --%>


        <div class="reg-form">
            <div class="container">
                <div class="reg col-md-6 col-sm-3 col-lg-6">
                    <h3>Register Now</h3>
                    <p>Welcome, please enter the following details to continue.</p>
                    <p>If you have previously registered with us, <a href="#">click here</a></p>
                    <spring:url var="registerUrl" value="/register" />
                    <form:form id="signupform"   method="post" modelAttribute="userReg" action="${registerUrl}">

                        <!--                        <div id="signupalert" style="display:none" class="alert alert-danger">
                                                    <p>Error:</p>
                                                    <span></span>
                                                </div>-->

                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="email" class="text-info">Email</label>--> 
                                <form:input path="email"  id="email" type="text"    placeholder="Elektron poçt ünvanınızı daxil edin" />
                                <form:label id="email_errors" path="email" class="control-label" /> 
                            </div>
                        </spring:bind>



                        <spring:bind path="firstName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="firstName" class="text-info">Adınız</label>--> 
                                <form:input path="firstName" id="firstName" type="text"   placeholder="Soyadınızı daxil edin" />
                                <form:errors path="firstName" class="control-label" /> 
                            </div>
                        </spring:bind>

                        <spring:bind path="lastName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="lastName" class="text-info">Soyadınız</label>--> 
                                <form:input path="lastName" id="lastName" type="text"  placeholder="Soyadınız" />
                                <form:errors path="lastName" class="control-label" /> 
                            </div>
                        </spring:bind>

                        <spring:bind path="passwd">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="passwd" class="text-info">Şifrə</label>--> 
                                <form:input path="passwd" type="password" id="passwd" class="form-control "  placeholder="Şifrə minimal 6 simvoldan ibarət olmalıdır" />
                                <form:errors path="passwd" class="control-label" /> 
                            </div>
                        </spring:bind>

                        <spring:bind path="repasswd">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="repasswd" class="text-info">Təkrar Şifrə</label>--> 
                                <form:input path="repasswd" id="repasswd" type="password"  placeholder="Şifrə minimal 6 simvoldan ibarət olmalıdır" />
                                <form:errors path="repasswd" class="control-label" /> 
                            </div>
                        </spring:bind>

                        <spring:bind path="gender">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="gender" class="text-info">Cins</label>--> 
                                <form:select path="gender" id="gender"  class="form-control " >
                                    <form:option value="" selected="selected">Seçim et</form:option>
                                    <form:option value="1">Kişi</form:option>
                                    <form:option value="2">Qadın</form:option>
                                </form:select>
                                <form:errors path="gender" class="control-label" /> 
                            </div>
                        </spring:bind>     


                        <spring:bind path="phoneno">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <!--<label for="phoneno" class="text-info">Mobil</label>--> 
                                <form:input path="phoneno" id="phoneno" type="text" placeholder="Mobil nömrənizi daxil edin" />
                                <form:errors path="phoneno" class="control-label" /> 
                            </div>
                        </spring:bind>

                        <input type="submit"  id="idRegister" value="Register Now">
                    </form:form>
                    <form style="margin-top: 2px !important;" action="connect/facebook" method="POST">
                        <input type="hidden"  name="scope" value="user_posts" /> 
                        <input type="submit" style="background:  #0075b0" class="btn btn-primary" value="Sign Up  with Facebook">
                    </form>
                    <p class="click">By clicking this button, you are agree to my  <a href="privacyPolicy">Policy Terms and Conditions.</a></p> 



                </div>
            </div>
        </div> 

      <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>              



        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
