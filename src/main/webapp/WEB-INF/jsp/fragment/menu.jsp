<%-- 
    Document   : menu
    Created on : Oct 25, 2016, 1:04:05 AM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    </head>
    <body>
        <div class="mega_nav">
            <div class="container">
                <div class="menu_sec">
                    <!-- start header menu -->
                    <ul class="megamenu skyblue">
                        <li id="menulink0" class="grid">
                            <a  class="color1" href="${pageContext.request.contextPath}/index">Ana Menu</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <h4>Brendlər</h4>
                                            <ul> 
                                                <c:forEach items="${listWrapper.brandCatList}" varStatus="i" var="function"> 
                                                    <li >
                                                        <a  href="${pageContext.request.contextPath}/products?brands=[${function.id}]">${function.name}</a> 
                                                    </li>
                                                </c:forEach>
                                            </ul>	
                                        </div>							
                                    </div>
                           
                                </div>						
                            </div>
                        </li>

                        <c:forEach items="${listWrapper.categoryList}" varStatus="i" var="function">
                            <li id="menulink${function.catId}">
                                <a class="color1" href="${pageContext.request.contextPath}/products?catgs=[${function.catId}]">${function.name}</a>
                            </li>
                        </c:forEach>   
                    </ul>
                   
                    <div class="search">
                        <form action="products"   method="get">
                            <input type="text" name="keyValue" value="" placeholder="Axtarış...">
                            <input type="submit" value="">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>


        <script>
            //menu activate script
            $('#menulink'+${menuClassActive}).addClass(' active');
        </script>

    </body>
</html>
