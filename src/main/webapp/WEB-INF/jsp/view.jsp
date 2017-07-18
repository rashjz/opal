<%-- 
    Document   : login2
    Created on : Oct 28, 2016, 9:00:35 PM
    Author     : Rashad Javadov
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<!--https://siteorigin.com/thread/change-the-image-of-the-arrows-in-the-flexslider-of-metaslider/-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - ${product.title}</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/social-share-kit.css" rel="stylesheet" /> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flexslider_1.css" type="text/css"  media="screen" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/social-share-kit.js"></script> 
    </head>
    <body>
        <script type="text/javascript">
            SocialShareKit.init({
                onBeforeOpen: function (targetElement, network, paramsObj) {
                    console.log(arguments);
                },
                onOpen: function (targetElement, network, networkUrl, popupWindow) {
                    console.log(arguments);
                },
                onClose: function (targetElement, network, networkUrl, popupWindow) {
                    console.log(arguments);
                }
            });
        </script>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />


        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '213755122398029',
                    xfbml: true,
                    version: 'v2.5'
                });
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

        </script>

        <div class="single">
            <div class="container">
                <div class="col-md-12">
                    <div class="col-md-4 grid">		
                        <div class="flexslider">
                            <ul class="slides">
                                <c:forEach items="${images}" var="img">
                                    <li data-thumb="http://opal.az${img.imgName}" 
                                        onerror="this.onerror=null;this.data-thumb='${pageContext.request.contextPath}/resources/images/no-image-crop.png';">
                                        <div class="thumb-image"> 
                                            <c:choose>
                                                <c:when test = "${empty img.imgName}">
                                                    <img src="${pageContext.request.contextPath}/resources/images/no-image-crop.png" style="width: 250px; height: 250px;"/>
                                                </c:when>
                                                <c:otherwise> 
                                                    <img src="http://opal.az${img.imgName}" 
                                                         onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" 
                                                         data-imagezoom="true" class="img-responsive">
                                                </c:otherwise>
                                            </c:choose> 

                                        </div>
                                    </li>
                                </c:forEach >  
                            </ul>

                        </div>
                    </div>
                    <div class="col-md-8 single-top-in">          
                        <div class="details-left-info">
                            <h3>${product.title}</h3>
                            <h4>${product.categoryId.name} </h4>
                            <div class="simpleCart_shelfItem">
                                <p>
                                    <span style="font-weight: bold;" class="item_price qwe">Qiymət :  ${product.price} AZN</span> 
                                </p>

                                <form method="post" action="addtocard">
                                    <p class="qty">Say :</p>
                                    <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                                    <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
                                    <input type="hidden" id="code" name="code"  value="${product.PId}" />
                                    <div class="single-but item_add">
                                        <input type="submit" value="add to cart">
                                    </div>
                                </form>
                                <!--social share-->

                            </div>
                            <div class="flower-type">
                                <p>Brend  :  ${product.brandId.name}</p>
                                <p>Kateqoriya  :  ${product.categoryId.name}</p>
                                <p>Əlavə edilib  :  ${product.insertDate}</p>

                            </div>
                            <p class="desc">
                                ${product.description}
                            </p> 
                        </div>
                        <div class="ssk-sm ssk-group"  
                             data-url="opal.az/view?code=${dataCode}" 
                             data-text="${product.description}"
                             data-title="${product.title}" > <!--  data-image="$!{content.imgUrl}"   -->
                            <a  class="ssk ssk-facebook"></a>
                            <a  class="ssk ssk-twitter"></a>
                            <a  class="ssk ssk-google-plus"></a> 
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <!-- collapse -->
                    <!---728x90--->
                    <div class="panel-group collpse" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        Ətraflı
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body"> 
                                    <div  class="fb-comments" data-href="http://opal.az/view?code=${dataCode}#configurator" data-mobile="true" data-numposts="5"></div>
                                </div>
                            </div>
                        </div> 
                    </div>
                    <!-- collapse -->
                    <!-- related products -->
                    <div class="related-products">
                        <h3>Uyğun Məhsullar</h3> 
                        <c:forEach items="${sameCatProducts}" var="pro" varStatus="index" >
                            <div class="col-md-4 related products-grid">
                                <a href="<c:url value="view?code=${pro.PId}"/>">
                                    <c:if test="${fn:length(pro.productImageCollection) gt 0}">
                                        <c:choose>
                                            <c:when test = "${empty  pro.productImageCollection[0].imgName}">
                                                <img src="${pageContext.request.contextPath}/resources/images/no-image-crop.png" style="width: 250px; height: 250px;"/>
                                            </c:when>
                                            <c:otherwise>
                                                <img src="http://opal.az<c:out value="${pro.productImageCollection[0].imgName}" />" style="max-width: 200px;max-height: 200px;"
                                                     onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';"class="img-responsive">
                                            </c:otherwise>
                                        </c:choose> 

                                        <div class="simpleCart_shelfItem rel"> 
                                            <!--<p>-->
                                                <span class="overline"> Qiymət ${pro.price} AZN</span> 
                                                <span class="item_price val"></span>
                                                <!--</p>-->
                                            <!--                                <div class="single-but item_add">
                                                                                <input type="submit" value="add to cart">
                                                                            </div>-->
                                        </div>
                                    </c:if>
                                </a>
                            </div>
                        </c:forEach> 

                        <div class="clearfix"> </div>
                    </div>
                    <!-- //related products -->
                </div>
            </div>
        </div>
        <jsp:include page="fragment/footer.jsp" />
        <script src="${pageContext.request.contextPath}/resources/js/imagezoom.js"></script>
        <script  src="${pageContext.request.contextPath}/resources/js/jquery.flexslider.js"></script>

        <script>
// Can also be used with $(document).ready()
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide",
                    controlNav: "thumbnails"
                });
            });
        </script>
    </body>
</html>
