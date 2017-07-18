<%-- 
    Document   : test
    Created on : Apr 10, 2017, 4:42:47 PM
    Author     : Azik
--%>

<%-- 
    Document   : azer
    Created on : 06.04.2017, 7:48:30
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <!DOCTYPE html>
    <html>
        <head>
            <title>Validation web page</title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                        <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
                        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

                        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
                        <script src='js/fornumber.js'></script>

                        <script src='js/maskedinput.js'></script>

                        <script type="text/javascript" src="js/main.js"></script>
                        </head>
                        <body>

                            <div class="container">
                                <div class="reg">
                                    <h3>Register Now</h3>
                                    <p>Welcome, please enter the following details to continue.</p>
                                    <p>If you have previously registered with us, <a href="#">click here</a></p>


                                    <div class="form-group">
                                        <label>Ad:</label>
                                        <input id="firstName" class="form-control" type="text" placeholder="Adınızı daxil edin">
                                            <span id="firstName_errors" class="control-label"></span> 
                                    </div>

                                    <div class="form-group">
                                        <label>Soyad:</label>
                                        <input id="lastName" class="form-control" type="text" placeholder="Soyadınızı daxil edin">
                                            <span id="lastName_errors" class="control-label"></span> 
                                    </div>

                                    <form id="form">
                                        <div class="form-group">
                                            <label>Email:</label>
                                            <input id="email" class="form-control" type="email" name="email" placeholder="Elektron poçt ünvanınızı daxil edin">
                                                <i id="icon"></i>
                                                <span id="email_errors" class="control-label"></span>
                                        </div>
                                    </form>

                                    <div class="form-group">
                                        <label>Şifrə:</label>
                                        <input id="passwd" class="form-control" type="password" placeholder="Şifrə minimal 6 simvoldan ibarət olmalıdır">
                                            <span id="passwd_errors" class="control-label"></span> 
                                    </div>

                                    <div class="form-group">
                                        <label>Təkrar Şifrə:</label>
                                        <input id="repasswd" class="form-control" type="password" placeholder="Şifrə minimal 6 simvoldan ibarət olmalıdır">
                                            <span id="repasswd_errors" class="control-label"></span> 
                                    </div>

                                    <div class="form-group">
                                        <label for="gender">Cinsi:</label> 
                                        <select id="gender" name="gender" class="form-control ">
                                            <option value="" selected="selected">Seçim et</option>
                                            <option value="1">Kişi</option>
                                            <option value="2">Qadın</option>
                                        </select>
                                        <span id="gender_errors" class="control-label"></span> 
                                    </div>

                                    <br>

                                        <%-- Birinci usul telefon ucun--%>
                                        <div class="form-group">
                                            <label for="inputStartDate">Mobil:</label>
                                            <div class="input-group">
                                                <span class="input-group-addon"><i><b>+994</b></i></span>
                                                <input id="phoneno" class="form-control" type="text" placeholder="Mobil nömrənizi daxil edin">
                                                    <i id="icon"></i>
                                            </div>
                                            <span id="phoneno_errors" class="control-label"></span> 
                                        </div>

                                        <br>

                                            <%-- Ikinci usul telefon ucun--%>
                                            <div class="form-group">
                                                <label for="inputStartDate">Mobil:</label>
                                                <input id="phoneno2" class="form-control" type="text" placeholder="Mobil nömrənizi +994XXXXXXXXX bu formada daxil edin">
                                                    <i id="icon2"></i>
                                                    <span id="phoneno2_errors" class="control-label"></span> 
                                            </div>

                                            <br>

                                                <%-- Ucuncu usul telefon ucun--%>
                                                <div class="form-group">
                                                    <label for="inputStartDate">Mobil:</label>
                                                    <input id="phoneno3" class="form-control" type="text" placeholder="Mobil nömrənizi +994XXXXXXXXX bu formada daxil edin">
                                                        <i id="icon3"></i>
                                                        <span id="phoneno3_errors" class="control-label"></span> 
                                                </div>

                                                <br>

                                                    <input value="Register Now" type="submit" id="idRegisterNow">



                                                        <form style="margin-top: 2px !important;" action="connect/facebook" method="POST">
                                                            <br>
                                                                <input name="scope" value="user_posts" type="hidden"> 
                                                                    <input style="background:  #0075b0" class="btn btn-primary" value="Sign Up  with Facebook" type="submit">
                                                                        </form>
                                                                        <p class="click">By clicking this button, you are agree to my  <a href="privacyPolicy">Policy Terms and Conditions.</a></p> 
                                                                        </div>
                                                                        </div>



                                                                        </body>
                                                                        </html>