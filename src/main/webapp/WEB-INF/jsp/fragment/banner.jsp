<%-- 
    Document   : banner
    Created on : Oct 25, 2016, 3:39:33 PM
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
         <title>Opal.az - Məhsullar</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <style type="text/css">
            .list-group-item.active:hover{
                background-color: #f65a5b  !important;
                border-color: #d62c1a      !important;
            }
            .list-group-item.active, .list-group-item.active:hover {
                background-color: #f65a5b   !important;
                border-color: #e81810       !important;
            } 
        </style>
    </head>
    <body>

        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">  
                <c:forEach items="${listSilder}"  var="silder"> 
                    <c:choose>
                        <c:when test = "${silder.status eq 2}">
                            <div class="item active">
                                <img src="${silder.imageName}" style="width: 100%; height: 400px;"/>
                                <div class="carousel-caption">
                                    <h3>Yeni Kolleksiyalar</h3>
                    </div>
                </div>
                        </c:when>
                        <c:otherwise>
                            <div class="item">
                                        <c:choose>
                                    <c:when test = "${silder.imageName eq ''}">
                                        <img src="${pageContext.request.contextPath}/resources/images/no-image-crop.png" style="width: 100%; height: 400px;"/>
                                            </c:when>
                                            <c:otherwise>
                                        <img src="${silder.imageName}" style="width: 100%; height: 400px;"/>
                                            </c:otherwise>
                                        </c:choose>
                                <div class="carousel-caption">
                                    <!--<h3>Yeni Kolleksiyalar</h3>-->
                                </div>
                                    </div>
                        </c:otherwise>
                    </c:choose> 
                </c:forEach>

                                        </div>	

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                                            </a> 
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                                            </a>
        </div> <!-- Carousel -->

        <!--         //cate-bottom -->
        <!-- cate -->
        <div class="cate">
            <div class="container">
                <div class="cate-left">
                    <h3>Yeni <span>Son Məhsullar</span></h3>
                                </div>
                <div class="cate-right">
                    <!-- slider -->
                    <ul id="flexiselDemo1">
                        <c:forEach items="${listLast}" var="last"  >
                            <li>
                                <div class="sliderfig-grid">
                                    <a href="<c:url value="view?code=${last.productId.PId}"/>"> 
                                        <c:choose>
                                            <c:when test="${last.imgName == null}">
                                                <img  style="max-width: 200px;max-height: 200px;" 
                                                      src="${pageContext.request.contextPath}/resources/images/no-image-crop.png"  class="img-responsive" />
                                            </c:when> 
                                            <c:otherwise>
                                                <img style="max-width: 200px;max-height: 200px;" 
                                                     src="http://opal.az${last.imgName}" class="img-responsive" 
                                                     onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" />
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                            </div>
                            </li>
                        </c:forEach>
                    </ul>

                </div>
                <!-- //slider -->
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //cate -->
        <!-- cate -->
        <div class="cate">
            <div class="container">
                <div class="cate-left">
                    <h3>Ən Baxımlı <span>Məhsullarımız</span></h3>
                    </div>
                <div class="cate-right">
                    <!-- slider -->
                    <ul id="flexiselDemo2">
                        <c:forEach items="${listMost}" var="best"  >
                            <li>
                                <div class="sliderfig-grid">
                                    <a href="<c:url value="view?code=${best.productId.PId}"/>"> 
                                        <c:choose>
                                            <c:when test="${best.imgName == null}">
                                                <img style="max-width: 200px;max-height: 200px;" 
                                                     src="${pageContext.request.contextPath}/resources/images/no-image-crop.png"  class="img-responsive" />
                                            </c:when> 
                                            <c:otherwise>
                                                <img style="max-width: 200px;max-height: 200px;"   class="img-responsive"
                                                     src="http://opal.az${best.imgName}" 
                                                     onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" />
                                            </c:otherwise>
                                        </c:choose> 
                                    </a>
                            </div>
                            </li>
                        </c:forEach>
                    </ul>

                                </div>
                <!-- //slider -->
                <div class="clearfix"> </div>
                    </div>
                </div>
        <script>
            $('.carousel').carousel({
                interval: 6000
            });
        </script>
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo1").flexisel({
                    visibleItems: 4,
                    animationSpeed: 2000,
                    autoPlay: true,
                    autoPlaySpeed: 4000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 3
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 4
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                }
                }
                });
                $("#flexiselDemo2").flexisel({
                    visibleItems: 4,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 3
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 4
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                        }
                    });
            });
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.flexisel.js"></script>
    </body>
</html>
