$(document).ready(function () {

//    $("#phoneno").numeric();


//    $("#phoneno3").mask('+99999 999 99 99');
//    $("#phoneno3").click(function () {
//        $("#phoneno3").css("border", "white");
//        $("#phoneno3_errors").html('');
//    });


    $("#firstName").on('input', function () {
        if ($("#firstName").val() !== "") {
            $(this).css({'border': '1px solid #569b44'});
            $("#firstName_errors").html('');
        } else {
            $("#firstName").css("border", " 1px solid red");
            $("#firstName_errors").html('<p style=\"color : red\">Adınızı daxil edin</p>');
        }
    });

    $("#lastName").on('input', function () {
        if ($("#lastName").val() !== "") {
            $(this).css({'border': '1px solid #569b44'});
            $("#lastName_errors").html('');
        } else {
            $("#lastName").css("border", " 1px solid red");
            $("#lastName_errors").html('<p style=\"color : red\">Soyadınızı daxil edin</p>');
        }
    });

    $("#email").on('input', function () {
        if ($("#email").val() !== "") {
            $("#email").css("border", "white");
            $("#email_errors").html('');
            $("#email").blur(function () {
                if ($(this).val() != '') {
                    var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                    if (pattern.test($(this).val())) {
                        $(this).css({'border': '1px solid #569b44'});
                        $('#icon').html('<img src="ok.png"/>');
                    } else {
                        $(this).css({'border': '1px solid #ff0000'});
                        $("#email_errors").html('<p style=\"color : red\">Elektron poçt ünvanınızı düzgün daxil edin</p>');
                        $('#icon').html('<img src="close.png"/>');
                    }
                } else {
                    $(this).css({'border': '1px solid #ff0000'});
                    $("#email_errors").html('<p style=\"color : red\">Elektron poçt ünvanınızı daxil edin</p>');
                    $('#icon').html('<img src="close.png"/>');
                }
            });
        } else {
            $("#email").css("border", " 1px solid red");
            $("#email_errors").html('<p style=\"color : red\">Elektron poçt ünvanınızı daxil edin</p>');
        }
    });

    $("#passwd").on('input', function () {
        if ($("#passwd").val() !== "") {
            $("#passwd").css("border", "white");
            $("#passwd_errors").html('');
            if ($("#passwd").val().length >= 6) {
                $(this).css({'border': '1px solid #569b44'});
                $("#passwd_errors").html('');
            } else {
                $("#passwd").css("border", " 1px solid red");
                $("#passwd_errors").html('<p style=\"color : red\">Şifrə minimum 6 simvol daxil etməlisiniz</p>');
            }
        } else {
            $("#passwd").css("border", " 1px solid red");
            $("#passwd_errors").html('<p style=\"color : red\">Şifrənizi daxil edin</p>');
        }
    });

    $("#repasswd").on('input', function () {
        if ($("#repasswd").val() !== "") {
            $("#repasswd").css("border", "white");
            $("#repasswd_errors").html('');
            if ($("#repasswd").val().length >= 6) {
                $("#repasswd").css("border", "white");
                $("#repasswd_errors").html('');
                if ($("#repasswd").val() == $("#passwd").val()) {
                    $(this).css({'border': '1px solid #569b44'});
                    $("#repasswd_errors").html('');
                } else {
                    $("#repasswd").css("border", " 1px solid red");
                    $("#repasswd_errors").html('<p style=\"color : red\">Təkrar şifrəni düzgün daxil etmirsiniz</p>');
                }
            } else {
                $("#repasswd").css("border", " 1px solid red");
                $("#repasswd_errors").html('<p style=\"color : red\">Şifrə minimum 6 simvol daxil etməlisiniz</p>');
            }
        } else {
            $("#repasswd").css("border", " 1px solid red");
            $("#repasswd_errors").html('<p style=\"color : red\">Şifrənizi təkrar daxil edin</p>');
        }
    });

    $("#gender").on('input', function () {
        if ($("#gender").val() !== "") {
            $("#gender").css("border", "white");
            $("#gender_errors").html('');
            $(this).css({'border': '1px solid #569b44'});
        } else {
            $("#gender").css("border", " 1px solid red");
            $("#gender_errors").html('<p style=\"color : red\">Cinsinizi seçin</p>');
        }
    });
    /// Telefon 1 ci versiya 
//    $("#phoneno").on('input', function () {
//        if ($("#phoneno").val() !== "") {
//            $("#phoneno").css("border", "white");
//            $("#phoneno_errors").html('');
//
//        } else {
//            $("#phoneno").css("border", " 1px solid red");
//            $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
//        }
//    });

    // Telefon 2 ci versiya


    $("#phoneno").on('input', function () {
        if ($("#phoneno").val() !== "") {
            $("#phoneno").css("border", "white");
            $("#phoneno_errors").html('');
            $("#phoneno").blur(function () {
                if ($(this).val() != '') {
                    var reg = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{2}[-\s\.]?[0-9]{3}?[-\s\.]?[0-9]{2}?[-\s\.]?[0-9]{2}$/;
                    if (reg.exec($(this).val())) {
                        $(this).css({'border': '1px solid #569b44'});
                        $('#icon').html('<img src="ok.png"/>');
                    } else {
                        $(this).css({'border': '1px solid #ff0000'});
                        $('#icon2').html('<img src="close.png"/>');
                        $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi düzgün daxil edin</p>');
                    }
                } else {
                    $(this).css({'border': '1px solid #ff0000'});
                    $('#icon').html('<img src="close.png"/>');
                    $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
                }
            });
        } else {
            $("#phoneno").css("border", " 1px solid red");
            $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
        }
    });


    $("#idRegisterNow").click(function () {
        if ($("#firstName").val() == "" && $("#lastName").val() == "" && $("#email").val() == "" && $("#passwd").val() == "" && $("#repasswd").val() == "" && $("#gender").val() == "" && $("#phoneno").val() == "") {
            $("#firstName").css("border", " 1px solid red");
            $("#firstName_errors").html('<p style=\"color : red\">Adınızı daxil edin</p>');
            $("#lastName").css("border", " 1px solid red");
            $("#lastName_errors").html('<p style=\"color : red\">Soyadınızı daxil edin</p>');
            $("#email").css("border", " 1px solid red");
            $("#email_errors").html('<p style=\"color : red\">Elektron poçt ünvanınızı daxil edin</p>');
            $("#passwd").css("border", " 1px solid red");
            $("#passwd_errors").html('<p style=\"color : red\">Şifrənizi daxil edin</p>');
            $("#repasswd").css("border", " 1px solid red");
            $("#repasswd_errors").html("<p style=\"color : red\">Şifrənizi təkrar daxil edin</p>");
            $("#gender").css("border", " 1px solid red");
            $("#gender_errors").html('<p style=\"color : red\">Cinsinizi seçin</p>');
            $("#phoneno").css("border", " 1px solid red");
            $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
//            $("#phoneno2").css("border", " 1px solid red");
//            $("#phoneno2_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
//            $("#phoneno3").css("border", " 1px solid red");
//            $("#phoneno3_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
        } else if ($("#firstName").val() == "") {
            $("#firstName").css("border", " 1px solid red");
            $("#firstName_errors").html('<p style=\"color : red\">Adınızı daxil edin</p>');
        } else if ($("#lastName").val() == "") {
            $("#lastName").css("border", " 1px solid red");
            $("#lastName_errors").html('<p style=\"color : red\">Soyadınızı daxil edin</p>');
        } else if ($("#email").val() == "") {
            $("#email").css("border", " 1px solid red");
            $("#email_errors").html('<p style=\"color : red\">Elektron poçt ünvanınızı daxil edin</p>');
        } else if ($("#passwd").val() == "") {
            $("#passwd").css("border", " 1px solid red");
            $("#passwd_errors").html('<p style=\"color : red\">Şifrənizi daxil edin</p>');
        } else if ($("#repasswd").val() == "") {
            $("#repasswd").css("border", " 1px solid red");
            $("#repasswd_errors").html("<p style=\"color : red\">Şifrənizi təkrar daxil edin</p>");
        } else if ($("#gender").val() == "") {
            $("#gender").css("border", " 1px solid red");
            $("#gender_errors").html('<p style=\"color : red\">Cinsinizi seçin</p>');
        } else if ($("#phoneno").val() == "") {
            $("#phoneno").css("border", " 1px solid red");
            $("#phoneno_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
      } 
//        else if ($("#phoneno2").val() == "") {
//            $("#phoneno2").css("border", " 1px solid red");
//            $("#phoneno2_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
//        } else if ($("#phoneno3").val() == "") {
//            $("#phoneno3").css("border", " 1px solid red");
//            $("#phoneno3_errors").html('<p style=\"color : red\">Mobil nömrənizi daxil edin</p>');
//        }
         else {
            $("#firstName").css("border", "white");
            $("#firstName_errors").html('');
            $("#lastName").css("border", "white");
            $("#lastName_errors").html('');
            $("#email").css("border", "white");
            $("#email_errors").html('');
            $("#passwd").css("border", "white");
            $("#passwd_errors").html('');
            $("#repasswd").css("border", "white");
            $("#repasswd_errors").html('');
            $("#gender").css("border", "white");
            $("#gender_errors").html('');
            $("#phoneno").css("border", "white");
            $("#phoneno_errors").html('');
            $("#phoneno2").css("border", "white");
            $("#phoneno2_errors").html('');
            $("#phoneno3").css("border", "white");
            $("#phoneno3_errors").html('');
        }

    });



});

