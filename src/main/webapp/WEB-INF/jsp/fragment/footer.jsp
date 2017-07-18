<!--
    Document   : footer
    Created on : Oct 25, 2016, 1:04:16 AM
    Author     : Azik
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Əl İşləri</title>
    </head>
    <body>
        <div class="footer">
            <div class="container">
                <div class="col-md-4 footer-grid">
                    <h6>Haqqımızda</h6>
                    <p>Bizim Əl işlərimiz induvidual olaraq hazırlanır. Bizim hazırladığımız   əsərlər insanlara unudulmaz müsbət enerji, müsbət emosiyalar verir və hər hansı bir şəxsin həyatını uzadır. </p>
                </div>
                <div class="col-md-4 footer-grid">
                    <h6>Məlumat</h6>
                    <ul>
                        <li><a href="contact">Əlaqə</a></li>
                        <li><a href="<c:url value="/privacyPolicy"/>">Gizlilik Siyasəti</a></li>
                        <li><a href="<c:url value="/termsConditions"/>">Şərtlər və Qaydalar</a></li> 
                    </ul>
                </div>
               
                <div class="col-md-4 footer-grid"> 
                    <ul>
                        <div class="fb-page" data-href="https://www.facebook.com/Shamyabijouterie/" data-small-header="true" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/Shamyabijouterie/" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/Shamyabijouterie/">Opal.az</a></blockquote></div>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="footer-copy">
            <p>© 2016 Opal.az. Bütün Hüquqlar Qorunur!</p>
        </div>
    </body>
</html>
