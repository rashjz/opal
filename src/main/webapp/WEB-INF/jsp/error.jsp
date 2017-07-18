<%-- 
    Document   : error
    Created on : Sep 23, 2016, 2:47:15 PM
    Author     : Rashad Javadov
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>ERROR Page</title>
         <link rel="shortcut icon"  href="${pageContext.request.contextPath}/resources/images/logo.png" type="image/png">
    </head>
    <body>
        <h1>Error Page</h1>
        <p>Application has encountered an error. Please contact support on ...</p>


        Failed URL: ${url}
        Exception:  ${exception.message}
    <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>

</body>
</html>
