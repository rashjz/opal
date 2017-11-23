<%-- 
    Document   : productUser
    Created on : Jan 23, 2017, 4:45:46 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/productPagingTag.tld"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'> 
        <title>Users Product</title>
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />
        <spring:url value="/productsuser" var="productsuser" />
        <div class="container">
            <div class="check">	 
                <div class="row" style="margin-bottom: 1%">   
                    <div class="col-md-9 ">
                        <form:form id="headerSearchForm" action="productsuser" modelAttribute="productsuser" class="col-sm-12 col-md-12 col-lg-12"  method="GET">
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
                                        <option value=0>Category</option>
                                        <c:forEach items="${categoryList}" var="cat">
                                            <option value="${cat.catId}">${cat.name}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                    <form:select id="keyValue" class="btn  btn active" path="genderId.genderId">
                                        <option value=0>Gender</option>
                                        <c:forEach items="${genderList}" var="gn">
                                            <option value="${gn.genderId}">${gn.type}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-sm-3 col-md-3 col-lg-3"> 
                                    <form:select id="keyValue" class="btn  btn active" path="brandId.id">
                                        <option value="0">Brand</option>
                                        <c:forEach items="${brandList}" var="br">
                                            <option value="${br.id}">${br.name}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="col-sm-3 col-md-3 col-lg-3 "> 
                                    <button type="submit"  class="btn btn-primary">Search</button>
                                </div>
                            </div>
                        </form:form>
                    </div> 
                </div>

<!--                <div class="col-md-3 cart-total">
                    <div style=".list-group-item.active {background-color:  red;}" class="list-group"> 
                        <a href="productsuser?typeId=1" id="shortlink1" data-type="1" class="list-group-item ">Məhsul Əlavə Et<span class="sr-only">(current)</span></a>
                        <a href="productsuser?typeId=1" id="shortlink1" data-type="1" class="list-group-item ">İcrada<span class="sr-only">(current)</span></a>
                        <a href="productsuser?typeId=2" id="shortlink2" data-type="2" class="list-group-item ">Çatdırılıb<span class="sr-only">(current)</span></a>
                        <a href="productsuser?typeId=3" id="shortlink3" data-type="3" class="list-group-item ">Səbətdə<span class="sr-only">(current)</span></a>
                    </div>
                    <div class="clearfix"></div>
                </div>-->

                <div class="col-md-9 cart-items">

                    <!--<h1>Səbətim $!{total}</h1>-->
                    <c:forEach items="${productsLists}" varStatus="i" var="order">

                        <div class="cart-sec simpleCart_shelfItem">
                            <div class="cart-item cyc"> 
                                <c:choose>
                                    <c:when test = "${fn:length(order.productImageCollection) gt 0}">
                                        <img src="http://opal.az<c:out value="${order.productImageCollection[0].imgName}" />" 
                                             onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/resources/images/no-image-crop.png';" 
                                             style="max-width: 200px;max-height: 200px;" class="img-responsive" />
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${pageContext.request.contextPath}/resources/images/no-image-crop.png" style="width: 200px; height: 200px;"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="cart-item-info">
                                <ul  class="qty">    
                                    <li><p>Qiymət : ${order.price} AZN</p></li>

                                    <li><p>Tarix : ${order.insertDate}</p></li>
                                </ul>
                                <div class="delivery">
                                    <p>Product : ${orders.title}</p>
                                    <span>Status : ${order.status}</span>
                                    <div class="clearfix"></div>
                                </div>	

                                <div class="fgh"> 
                                    <button type="submit"   class="btn btn-primary">
                                        <span class="glyphicon glyphicon-credit-card"></span> Add To Cart
                                    </button>
                                    <a href="<c:url value="editproduct/${order.PId}"/>" style="margin-left: 3px;">
                                        <span class="glyphicon glyphicon-edit"></span>
                                    </a>
                                   <a href="<c:url value="${pageContext.request.contextPath}/view?code=${order.PId}"/>" style="margin-left: 3px;">
                                        <span class="glyphicon glyphicon-zoom-in"></span>
                                    </a>
                                    <a data-toggle="modal" data-id="${order.price}" style="margin-left: 3px;" data-backdrop="static" 
                                       data-keyboard="true" data-target="#myModal" >
                                        <span class="glyphicon glyphicon-envelope"></span>
                                    </a> 
                                    
                                </div>
                            </div>
                            <div class="clearfix"></div>

                        </div>

                    </c:forEach>
                    <div style="margin-left: 10px;margin-top: 10px;" class="panel"> 
                        
                        <tag:paginate max="15" offset="${offset}"  count="${count}" title="${title}" price="${price}" toDate="${toDate}"  fromDate="${fromDate}" catgs="${catgs}" brands="${brands}" gendertype="${gendertype}" uri="productsuser"  keyValue="${keyValue}" next="&raquo;" previous="&laquo;" />
                    
                </div>
                </div>
                
                <div class="clearfix"> </div>
            </div>

        </div>

        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
