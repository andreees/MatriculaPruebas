<%-- 
    Document   : ModificarSeccion3
    Created on : 27/10/2014, 05:40:23 PM
    Author     : Roy Taza Rojas
--%>
<%@page import="pe.com.core.model.Clase"%>
<%@page import="pe.com.core.dao.SeccionDAO"%>
<%@page import="pe.com.core.dao.ClaseDAO"%>
<%@page import="pe.com.core.model.Seccion"%>
<%@page import="pe.com.core.dao.CursoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    UsuarioBean usuarioBean;
    HttpSession sesion = request.getSession(false);
    if (sesion == null) {
        response.sendRedirect("index.jsp");
    } else if (sesion.getAttribute(ConstantesWeb.USUARIO_INICIO) == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuarioBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
        if (!usuarioBean.getPrivilegio().equalsIgnoreCase(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR)) {
            response.sendRedirect("error.jsp?mensaje=No tienes privilegios de acceso");
        } else if (request.getParameter("idSeccion") == null) {
            response.sendRedirect("PrincipalAdministrador.jsp");
        } else if (request.getParameter("idSeccion").equals("")) {
            response.sendRedirect("PrincipalAdministrador.jsp");
        } else {
            String sIdCurso = request.getParameter("idCurso");
            String sIdSeccion = request.getParameter("idSeccion");
            String sIdClase = request.getParameter("idClase");

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

            CursoDAO cursoDAO = context.getBean(CursoDAO.class);
            SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
            ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

            Curso curso = cursoDAO.get(Integer.parseInt(sIdCurso));
            Seccion seccion = seccionDAO.get(Integer.parseInt(sIdSeccion));
            Clase clase = claseDAO.get(Integer.parseInt(sIdClase));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secciones - Modificar</title>
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
        <script>
            $(document).ready(function() {
                $("#menu_cursos").removeClass("current");
                $("#menu_secciones").addClass("current");
            });
        </script>
    </head>
    <body>
        <div id="Contenedor">
            <%@include file="template/CabeceraT.jsp" %>
            <%@include file="template/MenuLateralT.jsp" %>
            <div id="ContenidoCentral">
                <h3 id="MensajeBienvenida">Modificar Seccion</h3><br>
                <p>Ingrese la información de la secci&oacute;n</p>
                <!-- Table sortable -->
                <form action="ControllerSeccion" method="post">
                    <input type="hidden" name="action" value="<%= ConstantesWeb.MODIFICAR_SECCION%>">
                    <input type="hidden" name="idCurso" value="<%= sIdCurso%>">
                    <input type="hidden" name="idSeccion" value="<%= sIdSeccion%>">
                    <input type="hidden" name="idClase" value="<%= sIdClase%>">
                    <table class="tight" style="width: 60%">
                        <thead>
                            <tr>
                                <th colspan="2" style="text-align: center"><%= curso.getNombre()%></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Codigo de Seccion: </td>
                                <td><input id="txtCodigoSeccion" type="text" name="txtCodigoSeccion" value="<%= seccion.getCodigo()%>" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Profesor: </td>
                                <td><input id="txtProfesor" type="text" name="txtProfesor" value="<%= seccion.getProfesor()%>" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Salon: </td>
                                <td><input id="txtSalon" type="text" name="txtSalon" value="<%= clase.getCodigo()%>" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Dia: </td>
                                <td>
                                    <select id="cbDia" name="cbDia">
                                        <option id="itemLunes" value="Lunes" <%if (clase.getDia().equalsIgnoreCase("Lunes")) {%>selected<%}%> >Lunes</option>
                                        <option id="itemMartes" value="Martes" <%if (clase.getDia().equalsIgnoreCase("Martes")) {%>selected<%}%> >Martes</option>
                                        <option id="itemMiercoles" value="Miercoles" <%if (clase.getDia().equalsIgnoreCase("Miercoles")) {%>selected<%}%> >Miercoles</option>
                                        <option id="itemJueves" value="Jueves" <%if (clase.getDia().equalsIgnoreCase("Jueves")) {%>selected<%}%> >Jueves</option>
                                        <option id="itemViernes" value="Viernes" <%if (clase.getDia().equalsIgnoreCase("Viernes")) {%>selected<%}%> >Viernes</option>
                                        <option id="itemSabado" value="Sabado" <%if (clase.getDia().equalsIgnoreCase("Sabado")) {%>selected<%}%> >Sabado</option>
                                        <option id="itemDomingo" value="Domingo" <%if (clase.getDia().equalsIgnoreCase("Domingo")) {%>selected<%}%> >Domingo</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Hora Inicio: </td>
                                <td><input id="txtHoraInicio" type="number" name="txtHoraInicio" value="<%= clase.getHoraInicio()%>" min="7" max="23"></td>
                            </tr>
                            <tr>
                                <td>Hora Fin </td>
                                <td><input id="txtHoraFin" type="number" name="txtHoraFin" value="<%= clase.getHoraFin()%>" min="7" max="23"></td>
                            </tr>
                            <tr>
                                <td>Tipo de clase: </td>
                                <td>
                                    <select id="cbTipoClase" name="cbTipoClase">
                                        <option id="itemTeoria" value="Teoria" <%if (clase.getTipoClase().equalsIgnoreCase("Teoria")) {%>selected<%}%> >Teoria</option>
                                        <option id="itemLaboratorio" value="Laboratorio" <%if (clase.getTipoClase().equalsIgnoreCase("Laboratorio")) {%>selected<%}%> >Laboratorio</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center"><input id="btnGuardarSeccion" type="submit" name="btnGuardarSeccion" value="Guardar Seccion"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
<%
        }
    }
%>