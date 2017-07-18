<%-- 
    Document   : product
    Created on : Oct 30, 2016, 6:00:45 AM
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
        <title>Opal.az - Əl İşləri</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>

        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />
        <spring:url value="/products" var="products" />
        <!-- products -->
        <div class="products">
            <div class="container">
                <div class="products-grids">
                    <div class="col-md-9 products-grid-left">
                        <div class="products-grid-lft">
                            <c:forEach items="${productList}" var="products" varStatus="index" > 

                                <div class="products-grd">
                                    <div class="p-one simpleCart_shelfItem prd">
                                        <a href="<c:url value="view?code=${products.PId}"/>">
                                            <c:choose>
                                                <c:when test = "${fn:length(products.productImageCollection) gt 0}">
                                                    <img src="http://opal.az<c:out value="${products.productImageCollection[0].imgName}" />" 
                                                         onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" 
                                                         style="max-width: 200px;max-height: 200px;" class="img-responsive" />
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="${pageContext.request.contextPath}/resources/images/no-image-crop.png" style="width: 200px; height: 200px;"/>
                                                </c:otherwise>
                                            </c:choose>

                                            <div class="mask">
                                                <span>Quick View</span>
                                            </div>
                                        </a>
                                        <h4>${products.title} </h4> 
                                        <p>
                                            <a class="item_add" href="<c:url value="view?code=${products.PId}"/>">
                                                <i></i> <span class=" item_price valsa">${products.price} AZN</span>
                                            </a>
                                        </p>
                                        <div class="pro-grd">
                                            <a href="<c:url value="view?code=${products.PId}"/>">${products.price} AZN</a>
                                        </div>
                                    </div>	
                                </div>

                                <c:if test="${index.count % 3 == 0}">
                                    <div class="clearfix"></div>
                                </div>
                            </c:if>
                            <c:if test="${index.count==3 || index.count==6 }">
                                <div class="products-grid-lft">

                                </c:if>
                                <c:if test="${index.count==9 }">
                                    <div>
                                        <br/>
                                        <tag:paginate max="15" offset="${offset}" catgs="${catgs}" gendertype="${gendertype}" brands="${brands}" count="${count}" uri="products"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                                    </div> 
                                </div>

                            </c:if>

                        </c:forEach>
                        <c:if test="${fn:length(productList) ==3 || fn:length(productList) ==6}">   

                            <div>
                                <br/>
                                <tag:paginate max="15" offset="${offset}" catgs="${catgs}" gendertype="${gendertype}" brands="${brands}" count="${count}" uri="products"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                            </div> 
                        </div>
                    </div> 
                </c:if>
                <c:if test="${fn:length(productList)%3 != 0}">   
                    <div class="clearfix"></div>
                    <div>
                        <br/>
                        <tag:paginate max="15" offset="${offset}" catgs="${catgs}" gendertype="${gendertype}" brands="${brands}" count="${count}" uri="products"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                    </div> 
                </div>
            </div>
        </c:if>



        <div class="col-md-3 products-grid-right">
            <div class="w_sidebar">


                <script type="text/javascript">
                    $(document).ready(function () {
                    <c:if test="${not empty catgs}">
                        $.each(${catgs}, function (index, value) {
                            //                                        console.log(index + ': ' + value);   // alerts 0:[1 ,  and  1:2]
                            $('input[type=checkbox][name=category][data-id=' + value + ']').prop('checked', true);
                        });
                    </c:if>
                    <c:if test="${not empty brands}">
                        $.each(${brands}, function (index, value) {
                            //                                        console.log(index + ': ' + value);   // alerts 0:[1 ,  and  1:2]
                            $('input[type=checkbox][name=brand][data-id=' + value + ']').prop('checked', true);
                        });
                    </c:if>
                    });

                    function categoryChecked() {
                        var categories = [];
                        $.each($("input[name='category']:checked"), function () {
                            categories.push($(this).data('id'));
                        });
                        //                                    console.log(JSON.stringify(categories));
                        $("input[type='hidden'][name=catgs]").val(JSON.stringify(categories));
                        //                                    window.location.href='http://localhost:8080/HandWork/products?catgs='+JSON.stringify(categories);
                    }
                    function brandChecked() {
                        var brands = [];
                        $.each($("input[name='brand']:checked"), function () {
                            brands.push($(this).data('id'));
                        });
                        $("input[type='hidden'][name=brands]").val(JSON.stringify(brands));
                        //                                    console.log(JSON.stringify(brands));
                        //                                    window.location.href='http://localhost:8080/HandWork/products?brands='+JSON.stringify(brands);
                    }
                </script>


                <div class="w_nav1">
                    <h4>Cins Kateqoriyası</h4>
                    <ul>
                        <c:forEach items="${listWrapper.genders}" varStatus="i" var="function">
                            <li><a href="<c:url value="/products?gendertype=${function.genderId}"/>">${function.type}</a></li>
                            </c:forEach>
                    </ul>	
                </div>
                <section  class="sky-form">
                    <h4>Kateqoriyalar</h4>
                    <div class="row1 scroll-pane">
                        <div class="col col-4"> 
                            <c:forEach items="${listWrapper.categoryList}" varStatus="i" var="function">
                                <label class="checkbox">
                                    <input type="checkbox" data-id="${function.catId}" onclick="categoryChecked()" name="category">
                                    <i></i>${function.name}
                                </label><br/> 
                            </c:forEach> 
                        </div> 
                    </div>
                </section>
                <section  class="sky-form">
                    <h4>Brendlər</h4>
                    <div class="row1 scroll-pane">
                        <div class="col col-4"> 
                            <c:forEach items="${listWrapper.brandCatList}" varStatus="i" var="function">
                                <label class="checkbox">
                                    <input type="checkbox" data-id="${function.id}" onclick="brandChecked()" name="brand">
                                    <i></i>${function.name}
                                </label><br/>
                            </c:forEach> 
                        </div> 
                    </div>
                </section>
                <form  action="products" method="get">
                    <input type="hidden" name="catgs" value="${catgs}" >
                    <input type="hidden" name="brands" value="${brands}" >
                    <input type="submit" value="Search" class="btn btn-lg btn-danger btn-block">
                </form>
            </div>
            <div class="clearfix"></div>

        </div>


    </div>
</div>
<!-- //products -->

<jsp:include page="fragment/footer.jsp" />

</body>
</html>
