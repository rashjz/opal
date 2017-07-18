<%-- 
    Document   : menuAdmin
    Created on : Nov 7, 2016, 10:24:16 AM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    </head>
    <body>
        <nav class="navbar-default navbar-side" role="navigation">
            <div id="sideNav" href="#"><i class="fa fa-caret-right"></i></div>
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="${pageContext.request.contextPath}/admin/users"><i class="fa fa-user"></i>Users</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/productsadmin"><i class="fa fa-edit"></i> Product</a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-opencart"></i> Order <span class="fa cart"></span>
                        </a>
                        <ul class="nav nav-second-level active-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/checkoutList?statusId.Id=3"><i class="fa fa-money"></i>Səbət</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/checkoutList?statusId.Id=2"><i class="fa fa-check"></i>Təhvil Verilən</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/checkoutList?statusId.Id=1"><i class="fa fa-lock"></i>Gözləmədə olanlar</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/checkoutList?statusId.Id=4"><i class="fa fa-trash"></i>Silinən</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/categoryAdmin"><i class="fa fa-bar-chart-o"></i> Category </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/brands"><i class="fa fa-qrcode"></i> Brand</a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/admin/faqAdmin"><i class="fa fa-question"></i> FAQ</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/listMassage"><i class="fa fa-envelope"></i> İsmarıc</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/slideradmin"><i class="fa fa-envelope"></i> Slider</a>
                    </li>
                    
                </ul>

            </div>

        </nav>
    </body>
</html>
