<%-- 
    Document   : faq
    Created on : Nov 4, 2016, 10:26:56 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sual - Cavab</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />
        <div class="container">
            <br />
            <br />


            <div class="panel-group" id="accordion">
                <div class="faqHeader">General questions</div>
                <c:forEach items="${listFaq}" var="faq">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse${faq.id}">${faq.question}</a>
                            </h4>
                        </div>
                        <div id="collapse${faq.id}" class="panel-collapse collapse ">
                            <div class="panel-body">
                                ${faq.answer}
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />
        <style>
            .faqHeader {
                font-size: 27px;
                margin: 20px;
            }

            .panel-heading [data-toggle="collapse"]:after {
                font-family: 'Glyphicons Halflings';
                content: "\e072"; /* "play" icon */
                float: right;
                color: #F58723;
                font-size: 18px;
                line-height: 22px;
                /* rotate "play" icon from > (right arrow) to down arrow */
                -webkit-transform: rotate(-90deg);
                -moz-transform: rotate(-90deg);
                -ms-transform: rotate(-90deg);
                -o-transform: rotate(-90deg);
                transform: rotate(-90deg);
            }

            .panel-heading [data-toggle="collapse"].collapsed:after {
                /* rotate "play" icon from > (right arrow) to ^ (up arrow) */
                -webkit-transform: rotate(90deg);
                -moz-transform: rotate(90deg);
                -ms-transform: rotate(90deg);
                -o-transform: rotate(90deg);
                transform: rotate(90deg);
                color: #454444;
            }
        </style>
    </body>
</html>
