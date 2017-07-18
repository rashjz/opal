<%-- 
    Document   : contact
    Created on : Oct 28, 2016, 10:13:35 PM
    Author     : rasha_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Əlaqə</title>
        <meta name="google-site-verification" content="Kzwt8fKZ6Vj0r-dF_z4qlsFS7AHU5ns936Jb5KBMY48" />
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />

        <!-- contact -->
        <div class="contact-bottom">
            <!--<iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d96908.54934770924!2d-73.74913540000001!3d40.62123259999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sanimal+rescue+service+near+Inwood%2C+New+York%2C+NY%2C+United+States!5e0!3m2!1sen!2sin!4v1436335928062" frameborder="0" style="border:0" allowfullscreen></iframe>-->
      </div>
        <div class="contact">
            <div class="container">
                <div class="col-md-4 contact-left">
                    <h3>Ünvan/Address</h3>
                    <p>BAKU AZERBAIJAN, AZERBAIJAN 1009 <br/>
                        Bakı Şəhəri Nəsimi rayonu Nizami Küçəsi 
                        
                        <span>Bina 26 Mağaza 31</span></p>
                    <ul>
                        <li>Free Phone :+994702234411</li>
                        <li>Telephone :+994554961177</li>
                        <li>Fax :+994554961177</li>
                        <li><a href="mailto:info@opal.az">info@opal.az</a></li>
                    </ul>
                </div>
                <div class="col-md-8 contact-left">
                    <h3>Əlaqə</h3>
                    <form action="submitmessage" method="get">
                        <input type="text" placeholder="Adınız" name="name" onfocus="this.value = '';" onblur="if (this.value === '') {
                                    this.value = 'Name';
                                }" required="">
                                <input type="email"  placeholder="Emailiniz" name="email" onfocus="this.value = '';" onblur="if (this.value === '') {
                                            this.value = 'Email';
                                        }" required="">
                        <input type="text" placeholder="Mobil"  name="phone" onfocus="this.value = '';" onblur="if (this.value === '') {
                                            this.value = 'Telephone';
                                        }" required="">
                        <textarea type="text"   name="ymsg"  onfocus="this.value = '';" onblur="if (this.value === '') {
                                    this.value = 'Mesajınız...';
                                }" required="">Message...</textarea>
                        <input type="submit" value="Göndər" >
                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //contact -->
        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
