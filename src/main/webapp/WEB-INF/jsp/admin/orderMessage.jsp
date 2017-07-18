<%-- 
    Document   : orderMessage
    Created on : Nov 22, 2016, 2:02:34 PM
    Author     : Azik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/mainPagingTag.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal.az - Admin</title>
        <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="template/headerAdmin.jsp" />
            <jsp:include page="template/menuAdmin.jsp" />
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="col-md-12">  
                        <div class="panel panel-default panel-table">  
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col col-xs-6">
                                        <a href="<c:url value="brand/add"/>" role="button" class="btn btn-info  btn " aria-pressed="true"  >New Brand</a>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty msg}">
                                    <div class="alert alert-${css} alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <strong>${msg}</strong>
                                    </div>
                                </c:if> 
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-list">
                                        <thead>
                                            <tr>

                                                <th class="hidden-xs">ID</th>
                                                <th>Login</th>

                                                <th>Phone</th>
                                                <th>Message</th>
                                                <th>Insert Date</th>


                                                <th><em class="fa fa-cog "></em></th>
                                            </tr> 
                                        </thead>
                                        <c:forEach items="${messageList}" var="mss">
                                            <tbody>
                                                <tr>
                                                    <td class="col-sm-1">${mss.key}</td>
                                                    <td class="col-sm-1">${mss.userId.username}</td>
                                                    <td class="col-sm-2">${mss.phone}</td>
                                                    <td class="col-sm-3">${mss.message}</td>
                                                    <td class="col-sm-3">${mss.insertDate }</td>
                                                    <td class="col-sm-3" align="center">
                                                        <a data-toggle="modal" class="btn btn-success" data-id="${mss.PId.PId}" 
                                                           data-username="${mss.userId.username}" data-messages="${mss.message}" data-backdrop="static" 
                                                           data-keyboard="true"  data-phone="${mss.phone}" data-target="#myModal" >
                                                            <em class="fa fa-pencil"></em>
                                                        </a>
                                                        <a href="<c:url value="userListMassage/${mss.userId.userId}/${mss.PId.PId}"/>" class="btn btn-info"><em class="fa fa-search"></em></a>
                                                    </td>
                                                </tr>                  
                                            </tbody> 
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="template/footerAdmin.jsp" />
                </div>
            </div>
        </div>



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
                                <label class="col-xs-3 control-label">User</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control"  name="login" readonly/>
                                </div>
                                <span id="helpBlock1" class="text-danger"></span>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Phone</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control"  name="phone" readonly/>
                                </div>
                                <span id="helpBlock1" class="text-danger"></span>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Incoming Message</label>
                                <div class="col-xs-5">
                                    <textarea type="text" class="form-control" name="incomingMessage" readonly></textarea>
                                </div>
                                <span id="helpBlock3" class="text-danger"></span>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Reply Message</label>
                                <div class="col-xs-5">
                                    <textarea type="text" class="form-control"  name="replyMessage" ></textarea>
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
            $('#myModal').on('show.bs.modal', function (e) {
                //get data-id attribute of the clicked element
                $(e.currentTarget).find('span').text('');
                //empty span elements
                var dataId = $(e.relatedTarget).data('id');
                var message = $(e.relatedTarget).data('messages');
                var username = $(e.relatedTarget).data('username');
                var phone = $(e.relatedTarget).data('phone');

                $(e.currentTarget).find('input[name="dataId"]').val(dataId);
                $(e.currentTarget).find('textarea[name="incomingMessage"]').val(message);
                $(e.currentTarget).find('input[name="login"]').val(username);
                $(e.currentTarget).find('input[name="phone"]').val(phone);
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
                var name = $("input[name=login]").val();
                var message = $("textarea[name=replyMessage]").val();
                var dataId = $("input[name=dataId]").val();
                console.log(phone + ' ' + name + ' ' + message + ' ' + dataId);
                data["message"] = message;

                var pId = {};
                pId["pId"] = parseInt(dataId);
                data["pId"] = pId;
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
                console.log(JSON.stringify(data));
                if (datavalidation) {
                    $.ajax({
                        type: "post",
                        url: "sendOrdermessage",
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
    </body>
</html>
