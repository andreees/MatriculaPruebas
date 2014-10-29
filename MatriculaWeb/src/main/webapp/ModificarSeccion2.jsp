<%-- 
    Document   : ModificarSeccion2
    Created on : Oct 23, 2014, 2:28:22 PM
    Author     : proyecto
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
            SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
            ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

            Curso curso = cursoDAO.get(Integer.parseInt(sIdCurso));
            List<Seccion> listSeccions = seccionDAO.listXIdCurso(curso.getIdCurso());
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
                <p>Seleccione la secci&oacute;n que desea modificar</p>
                <!-- ;Table sortable -->
                <table class="sortable">
                    <thead>
                        <tr>
                            <th>Seccion</th>
                            <td>Profesor</td>
                            <td>Dia</td>
                            <td>Hora Inicio</td>
                            <td>Hora Fin</td>
                            <td>Tipo de clase</td>
                            <th>Modificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Clase> listClases = new ArrayList<Clase>();
                            for (Seccion seccion : listSeccions) {
                                //listClases = claseDAO.listXIdSeccion(seccion.getIdcurso());
                                listClases = claseDAO.listXIdSeccion(seccion.getIdSeccion());
                                for (Clase clase : listClases) {
                        %>
                        <tr>
                            <td><%= seccion.getCodigo()%></td>
                            <td><%= seccion.getProfesor()%></td>
                            <td><%= clase.getDia()%></td>
                            <td><%= clase.getHoraInicio()%></td>
                            <td><%= clase.getHoraFin()%></td>
                            <td><%= clase.getTipoClase()%></td>
                            <td><a id="linkModificarSeccion" href="ModificarSeccion3.jsp?idCurso=<%= curso.getIdCurso()%>&idSeccion=<%= seccion.getIdSeccion()%>&idClase=<%= clase.getIdClase()%>"><i class="icon-edit"></i></a></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
<%
        }
    }
%>