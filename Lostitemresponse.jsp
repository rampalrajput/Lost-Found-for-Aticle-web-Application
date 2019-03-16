<%-- 
    Document   : Lostitemresponse
    Created on : Mar 15, 2019, 10:36:37 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="windows-1255"%>
<!DOCTYPE html>
<%
   Boolean result1=(boolean) request.getAttribute("result1");
  Boolean result2  =(boolean) request.getAttribute("result2");
  System.out.println(" result from lostitemjsp"+result1);
if(result1 && result2 ==true)
{
      out.println("success");
}
else
{
    out.println("Falied");
}

%>
  


