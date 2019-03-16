<%-- 
    Document   : showexception
    Created on : Mar 15, 2019, 10:42:24 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="windows-1255"%>

<!DOCTYPE html>
<html>
    <head>
        <title>ERROR</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <meta http-equiv="Cache-control" content="no-cache"/>
        <meta http-equiv="expires" content="-1"/>
        <meta http-equiv="pragma" content="no-cache"/>
    </head>
    <body><center> 
 <%
   Exception e=(Exception)request.getAttribute("exception");
    String msg=e.getMessage();
    System.out.println("Exception is"+e);
    out.println("<h1 style='color:red'>Some Problem Occurred at Server<br>Try Again Later...</h1>"+msg);
%>
    </center>
    </body>
</html>


