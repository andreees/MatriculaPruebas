<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%
    UsuarioBean userBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
%>
<div id="Cabecera">
    <img src="assets/imagenes/logoUPC.png" width="50" height="50" alt="logoUPC"/><a href="PrincipalAdministrador.jsp" style="text-decoration: none">
        <label style="font-size: 25px">MATRICULA</label> - <label style="font-size: 20px">
        <%
            if(userBean.privilegio.equals(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR) ){
                %>ADMINISTRACIÓN<%
            }
            else{
                %>ALUMNO<%
            }
        %>
        </label></a>
    <form action="Logout" method="post"><input type="submit" value="Cerrar Sesion" name="btnCerrarSesion" style="float: right;margin-top: 13px;"/></form>
    <label id="lblUsuario" style="float: right;margin-top: 23px">Bienvenido <%= userBean.getNombres()%> <%= userBean.getApellidos()%>&nbsp;&nbsp;</label>   
</div>