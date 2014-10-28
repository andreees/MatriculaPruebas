<%-- 
    Document   : CrearSeccion2
    Created on : 22/10/2014, 07:38:58 PM
    Author     : Roy
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.com.core.dao.*"%>
<%@page import="pe.com.core.model.*"%>
<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%    UsuarioBean usuarioBean;
    HttpSession sesion = request.getSession(false);
    if (sesion == null) {
        response.sendRedirect("index.jsp");
    } else if (sesion.getAttribute(ConstantesWeb.USUARIO_INICIO) == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuarioBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
        if (!usuarioBean.getPrivilegio().equalsIgnoreCase(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR)) {
            response.sendRedirect("error.jsp?mensaje=No tienes privilegios de acceso");
        } else if (request.getParameter("idCurso") == null) {
            response.sendRedirect("PrincipalAdministrador.jsp");
        } else if (request.getParameter("idCurso").equals("")) {
            response.sendRedirect("PrincipalAdministrador.jsp");
        } else {
            String sIdCurso = request.getParameter("idCurso");
            
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            
            CursoDAO cursoDAO = context.getBean(CursoDAO.class);
            
            Curso curso = cursoDAO.get(Integer.parseInt(sIdCurso));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secciones - Crear</title>
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
                <h3 id="MensajeBienvenida">Crear Seccion</h3><br>
                <p>Ingrese la información de la secci&oacute;n</p>
                <!-- Table sortable -->
                <form action="ControllerSeccion" method="post">
                    <input type="hidden" name="action" value="<%= ConstantesWeb.CREAR_SECCION%>">
                    <input type="hidden" name="idCurso" value="<%= sIdCurso%>">
                    <table class="tight" style="width: 60%">
                        <thead>
                            <tr>
                                <th colspan="2" style="text-align: center"><%= curso.getNombre()%></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Codigo de Seccion: </td>
                                <td><input id="txtCodigoSeccion" type="text" name="txtCodigoSeccion" value="" maxlength="50" required></td>
                            </tr>
                            <tr>
                                <td>Profesor: </td>
                                <td><input id="txtProfesor" type="text" name="txtProfesor" value="" maxlength="50" required></td>
                            </tr>
                            <tr>
                                <td>Salon: </td>
                                <td><input id="txtSalon" type="text" name="txtSalon" value="" maxlength="50" required></td>
                            </tr>
                            <tr>
                                <td>Dia: </td>
                                <td>
                                    <select id="cbDia" name="cbDia">
                                        <option id="itemLunes" value="Lunes">Lunes</option>
                                        <option id="itemMartes" value="Martes">Martes</option>
                                        <option id="itemMiercoles" value="Miercoles">Miercoles</option>
                                        <option id="itemJueves" value="Jueves">Jueves</option>
                                        <option id="itemViernes" value="Viernes">Viernes</option>
                                        <option id="itemSabado" value="Sabado">Sabado</option>
                                        <option id="itemDomingo" value="Domingo">Domingo</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Hora Inicio: </td>
                                <td><input id="txtHoraInicio" type="number" name="txtHoraInicio" value="" min="7" max="23" required></td>
                            </tr>
                            <tr>
                                <td>Hora Fin </td>
                                <td><input id="txtHoraFin" type="number" name="txtHoraFin" value="" min="7" max="23" required></td>
                            </tr>
                            <tr>
                                <td>Tipo de clase: </td>
                                <td>
                                    <select id="cbTipoClase" name="cbTipoClase">
                                        <option id="itemTeoria" value="Teoria">Teoria</option>
                                        <option id="itemLaboratorio" value="Laboratorio">Laboratorio</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center"><input id="btnCrearSeccion" type="submit" name="btnCrearSeccion" value="Crear Seccion"></td>
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