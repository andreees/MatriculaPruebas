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
    if (session.getAttribute(ConstantesWeb.USUARIO_INICIO) == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuarioBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
        if (!usuarioBean.getPrivilegio().equalsIgnoreCase(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR)) {
            response.sendRedirect("error.jsp?mensaje=No tienes privilegios de acceso");
        }
    }
%>
<%
    String curso = "curso A";
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    List<Seccion> listSeccions = new ArrayList<Seccion>();
    SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
    listSeccions = seccionDAO.list();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secciones - Listar</title>
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
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
                    <input type="hidden" name="action" value="CrearSeccion">
                    <table class="sortable">
                        <thead>
                            <tr>
                                <th colspan="2" style="text-align: center"><%= curso%></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Seccion: </td>
                                <td>
                                    <select id="cbSeccion" name="cbSeccion">
                                        <%
                                            for (Seccion seccion : listSeccions) {
                                        %>
                                        <option id="itemSeccion" value="<%=seccion.getCodigo()%>"><%=seccion.getCodigo()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Profesor: </td>
                                <td><input id="txtProfesor" type="text" name="txtProfesor" value="" ></td>
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
                                <td><input id="txtHoraInicio" type="number" name="txtHoraInicio" value=""></td>
                            </tr>
                            <tr>
                                <td>Hora Fin </td>
                                <td><input id="txtHoraFin" type="number" name="txtHoraFin" value=""></td>
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