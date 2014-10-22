<%-- 
    Document   : error
    Created on : 22/10/2014, 04:30:58 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error Page</h1>
        <%
            if (request.getParameter("mensaje") != null) {
        %>
        <p style="color: red"><%= request.getParameter("mensaje")%></p>
        <%
            }
        %>
    </body>
</html>
