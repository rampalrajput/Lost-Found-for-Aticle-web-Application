<%-- 
    Document   : otpresponse
    Created on : Mar 15, 2019, 10:38:22 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="windows-1255"%>
<%
   String rno=(String)request.getAttribute("randomnumber");
   System.out.println("rno"+rno);
if(rno!=null)
{
      out.println(rno);
}
else
{
    out.println("invalid number");
}
  
%>
   