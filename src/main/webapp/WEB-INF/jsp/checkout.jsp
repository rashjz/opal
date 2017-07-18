<%-- 
    Document   : login2
    Created on : Oct 28, 2016, 9:00:35 PM
    Author     : Rashad Javadov
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Səbət</title>
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
        <jsp:include page="fragment/header.jsp" />
        <jsp:include page="fragment/menu.jsp" />





        <!--<script src="https://www.2checkout.com/static/checkout/javascript/direct.min.js"></script>-->
        <div class="container">
            <div class="check">	 
                <div class="col-md-3 cart-total">
                    <div style=".list-group-item.active {background-color:  red;}" class="list-group"> 
                        <!--<a href="checkout?typeId=1" id="shortlink1" data-type="1" class="list-group-item ">Məhsul Əlavə Et<span class="sr-only">(current)</span></a>-->
                        <a href="checkout?typeId=1" id="shortlink1" data-type="1" class="list-group-item ">İcrada<span class="sr-only">(current)</span></a>
                        <a href="checkout?typeId=2" id="shortlink2" data-type="2" class="list-group-item ">Çatdırılıb<span class="sr-only">(current)</span></a>
                        <a href="checkout?typeId=3" id="shortlink3" data-type="3" class="list-group-item ">Səbətdə<span class="sr-only">(current)</span></a>
                    </div>


                    <a class="continue" href="#">Continue to basket</a>
                    <div class="price-details">
                        <h3>Price Details</h3>
                        <!--<span>Total</span>-->
                        <!--<span id="totalVal1" class="total1">500</span>-->
                        <span>Count</span>
                        <span class="totalCount">${total}</span>
                        <!--                        <span>Delivery Charges</span>
                                                <span class="total1">150.00</span>-->
                        <div class="clearfix"></div>				 
                    </div>	

                    <ul class="total_price">
                        <li class="last_price"> <h4>TOTAL</h4></li>
                        <li class="last_price">
                            <span id="totalPrice" >${price}</span>
                        </li>
                        <div class="clearfix"></div>
                    </ul>

                    <div class="clearfix"></div>
                </div>
                <div class="col-md-9 cart-items">
                    <form action='https://2checkout.com/checkout/purchase' method='post'>
                        <input type='hidden' name='sid' value='1303908' >
                        <input type='hidden' name='mode' value='2CO' >
                        <input type='hidden' name='li_0_type' value='product' >
                        <input type='hidden' name='li_0_name' value='Example Product Name' >
                        <input type='hidden' name='li_0_product_id' value='Example Product ID' >
                        <input type='hidden' name='li_0__description' value='Example Product Description' >
                        <input type='hidden' name='li_0_price' value='1.00' >
                        <input type='hidden' name='li_0_quantity' value='2' >
                        <input type='hidden' name='li_0_tangible' value='N' >
                        <input type='hidden' name='card_holder_name' value='Checkout Shopper' >
                        <input type='hidden' name='street_address' value='123 Test St' >
                        <input type='hidden' name='street_address2' value='Suite 200' >
                        <input type='hidden' name='city' value='Baku' >
                        <input type='hidden' name='state' value='Baku' >
                        <input type='hidden' name='zip' value='43228' >
                        <input type='hidden' name='country' value='AZ' >
                        <input type='hidden' name='currency_code' value='AZN' >
                        <input type='hidden' name='email' value='test@2co.com' >
                        <input type='hidden' name='phone' value='103118881' >
                        <input type='hidden' name='phone_extension' value='197' >
                        <input type='hidden' name='purchase_step' value='payment-method' >
                        <!--<input name='submit' type='submit' value='Checkout' >-->
                        <!--</form>-->

                        <!--<h1>Səbətim $!{total}</h1>-->
                        <c:forEach items="${orders}" varStatus="i" var="order">



                            <script type="text/javascript">
                                $(document).ready(function (c) {
                                    $('.close${i.index}').on('click', function (c) {


                                        $('.cart-header${i.index}').fadeOut('slow', function (c) {
                                            $('.cart-header${i.index}').remove();
                                            var sendData = {};
                                            sendData["total"] = document.getElementById("totalPrice").innerHTML;
                                            sendData["count"] = '${order.productId.price}';
                                            sendData["orderid"] = '${order.id}';
                                            $.ajax({
                                                contentType: "application/json; charset=utf-8",
                                                dataType: "json",
                                                type: 'post',
                                                url: "${pageContext.request.contextPath}/emptycard?${_csrf.parameterName}=${_csrf.token}",
                                                                    data: JSON.stringify(sendData),
                                                                    success: function (data) {
                                                                        console.log("SUCCESS: ", data);
                                                                        document.getElementById("totalPrice").innerHTML = data.total;
                                                                    },
                                                                    error: function (callback) {
                                                                        console.log(callback);
                                                                    },
                                                                    done: function (e) {
                                                                        console.log("DONE");
                                                                    }
                                                                });
                                                            });
                                                        });
                                                    });
                            </script>
                            <div class="cart-header${i.index}">
                                <div class="close${i.index}" 
                                     style="background: url('${pageContext.request.contextPath}/resources/images/close_1.png') no-repeat 0px 0px;
                                     cursor: pointer;
                                     width: 28px;
                                     height: 28px;
                                     position: relative;
                                     left:  90%;
                                     top:0px;
                                     -webkit-transition: color 0.2s ease-in-out;
                                     -moz-transition: color 0.2s ease-in-out;
                                     -o-transition: color 0.2s ease-in-out;
                                     transition: color 0.2s ease-in-out;"> </div>
                                <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc"> 
                                        <c:choose>
                                            <c:when test = "${fn:length(order.productId.productImageCollection) gt 0}">
                                                <img src="http://opal.az<c:out value="${order.productId.productImageCollection[0].imgName}" />" 
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
                                            <li><p>Qiymət : ${order.productId.price} AZN</p></li>
                                            <li><p>Ədəd : ${order.count}</p></li>
                                            <li><p>Tarix : ${order.insertDate}</p></li>
                                        </ul>
                                        <div class="delivery">
                                            <p>Product : ${order.productId.title}</p>
                                            <span>Status : ${order.statusId.status}</span>
                                            <div class="clearfix"></div>
                                        </div>	
                                        <div class="fgh"> 
<!--                                            <button type="submit"   class="btn btn-primary">
                                                <span class="glyphicon glyphicon-credit-card"></span> Add To Cart
                                            </button>-->
                                            <a data-toggle="modal" data-id="${order.productId.price}" data-backdrop="static" 
                                               data-keyboard="true" data-target="#myModal" >
                                                <span class="glyphicon glyphicon-envelope"></span>
                                            </a> 
                                            <a href="<c:url value="view?code=${order.productId.PId}"/>" style="margin-left: 3px;">
                                                <span class="glyphicon glyphicon-zoom-in"></span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>

                                </div>
                            </div>
                        </c:forEach>
                    </form>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>



        <!-- Modal -->
        <div id="myModal"  tabindex="-1" role="dialog" class="modal fade" >
            <div class="modal-dialog"> 
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Message</h4>
                    </div>
                    <div class="modal-body">
                        <!--<form  id="formModal" class="form-horizontal" method="post">-->
                        <div class="form-horizontal">
                            <input type="hidden" name="dataId" id="dataId" value=""/>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Name</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control"   placeholder="Name" name="name" />
                                </div>
                                <span id="helpBlock1" class="text-danger"></span>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3 control-label">Telephone</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control"   placeholder="Telephone" name="phone" />
                                </div>
                                <span id="helpBlock2" class="text-danger"></span>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Message</label>
                                <div class="col-xs-5">
                                    <textarea type="text" class="form-control"  name="message" ></textarea>
                                </div>
                                <span id="helpBlock3" class="text-danger"></span>
                            </div> 
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" onclick="myFunction();" >Send</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                        <!--</form>-->
                    </div>
                </div>
            </div>

        </div>

        <script>
            //setting active to class param to left menu links example 
            $('#shortlink' +${typeId}).addClass('active');


            $('#myModal').on('show.bs.modal', function (e) {
                //get data-id attribute of the clicked element
                $(e.currentTarget).find('span').text('');
                //empty span elements
                var dataId = $(e.relatedTarget).data('id');
                $(e.currentTarget).find('input[name="dataId"]').val(dataId);
            });


            $('#myModal').on('hidden.bs.modal', function () {
                $.clearFormFields(this);
            });
            $.clearFormFields = function (area) {
                $(area).find('input[type="text"],input[type="email"],textarea,select').val('');
            };

            function myFunction() {
                var datavalidation = true;
                var data = {};


                var phone = $("input[name=phone]").val();
                var name = $("input[name=name]").val();
                var message = $("textarea[name=message]").val();
                var dataId = $("input[name=dataId]").val();
                console.log(phone + ' ' + name + ' ' + message + ' ' + dataId);
                data["message"] = message;
                data["pId"] = dataId;
                data["phone"] = phone;
                data["name"] = name;
                if (name === undefined || name === '' || name === null) {
                    datavalidation = false;
                    document.getElementById("helpBlock1").textContent = "Adınızı daxil edin";
                }
                if (phone === undefined || phone === '' || phone === null) {
                    datavalidation = false;
                    document.getElementById("helpBlock2").textContent = "Mobil nömrəni daxil edin";
                }
                if (message === undefined || message === '' || message === null) {
                    datavalidation = false;
                    document.getElementById("helpBlock3").textContent = "Mesajınızı daxil edin";
                }

                if (datavalidation) {
                    $.ajax({
                        type: "post",
                        url: "ordermessage",
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: function (data) {
                            $("[data-dismiss=modal]").trigger({type: "click"});
                        },
                        error: function (callback) {
                            console.log(callback);
                        },
                        done: function (e) {
                            console.log("DONE");
                        }
                    });
                }

            }
        </script>
        <jsp:include page="fragment/footer.jsp" />
    </body>
</html>
