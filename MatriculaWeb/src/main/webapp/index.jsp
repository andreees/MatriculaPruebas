<%-- 
    Document   : index
    Created on : 22/10/2014, 04:09:30 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula - Administrador</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
    </head>
    <body>
        <h3 id="MensajeBienvenida">&nbsp;</h3><br>
        <!-- Caption -->
        <div style="text-align: center;margin-left: 20%;margin-right: 20%">
            <form action="Login" method="post">
                <img src="assets/imagenes/upc-logo.png" alt="UPC" style="text-align: center"/>
                <br><br><br>
                <table align="center" style="margin-left: 25%;width: 100px">
                    <%
                        if (request.getParameter("mensaje") != null) {
                    %>
                    <tr>
                        <td colspan="2"><label style="color: red"><%= request.getParameter("mensaje")%></label></td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td>Usuario: </td>
                        <td><input type="text" name="txtUsuario" value="" maxlength="10" required></td>
                    </tr>
                    <tr>
                        <td>Contrase&ntilde;a: </td>
                        <td><input type="password" name="txtClave" value="" maxlength="10" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center"><input type="submit" name="btnIniciarSesion" value="Iniciar Sesion" ></td>
                    </tr>
                </table>
            </form>
        </div>
        <br><br><br><br><br><br><br>
        <%@include file="template/footer.jsp" %>
</html>

