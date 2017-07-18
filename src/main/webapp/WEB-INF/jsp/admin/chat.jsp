<%-- 
    Document   : chat
    Created on : Nov 23, 2016, 11:07:19 AM
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
        <link href="${pageContext.request.contextPath}/resources/css/chat.css" rel="stylesheet" />
        <title>Opal.az - Admin</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <div id="wrapper">
            <jsp:include page="template/headerAdmin.jsp" />
            <jsp:include page="template/menuAdmin.jsp" />

            <div id="page-wrapper">
                <div id="page-inner">

                    <div class="chat col-md-9">   
                        <div class="chat-history">
                            <ul class="chat-ul">
                                <c:forEach items="${userMessageList}" var="chat">
                                    <c:if test="${chat.status==1}">
                                        <li>
                                            <div class="message-data">
                                                <span class="message-data-name"><i class="fa fa-circle you">${chat.userId.firstname}  ${chat.userId.lastname}<br>${chat.insertDate} </i> </span>
                                            </div>
                                            <div class="message you-message">${chat.message}</div>
                                        </li>
                                    </c:if> 
                                    <c:if test="${chat.status==2}">
                                        <li class="clearfix">
                                            <div class="message-data align-right">
                                                <span class="message-data-name">you <br> ${chat.insertDate} </span> <i class="fa fa-circle me"></i>
                                            </div>
                                            <div class="message me-message float-right"> ${chat.message} </div>
                                        </li>
                                    </c:if>
                                </c:forEach> 
                            </ul>
                            <!--                            <div class="panel-footer">--> 
                            <form action="<c:url  value="chatmessage"/>" class="form-group-lg" method="post">
                                <div class="input-group">

                                    <input id="btn-input" type="text" name="adminmessage" class="form-control input-sm" placeholder="Mesajınızı adxil edin..." />
                                    <input  type="hidden" name="userId" value="${userId}" class="form-control input-sm"   />
                                    <input  type="hidden" name="pId" value="${pId}" class="form-control input-sm"   />
                                    <span class="input-group-btn lg">
                                        <button class="btn btn-warning btn-lg" id="btn-chat">Send</button>
                                    </span>

                                </div>
                            </form>
                            <!--</div-->

                        </div> <!-- end chat-history -->

                    </div> <!-- end chat -->
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>
            </div>
        </div>


    </body>
</html>
