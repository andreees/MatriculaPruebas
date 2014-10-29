<%-- 
    Document   : EliminarSeccion
    Created on : 20/10/2014, 03:39:37 PM
    Author     : Roy Taza Rojas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.com.core.dao.CursoDAO"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
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
        } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secciones - Eliminar</title>
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
                <h3 id="MensajeBienvenida">Eliminar Seccion</h3><br>
                <p>Seleccione el curso al cual pertenece la secci&oacute;n</p>
                <!-- Table sortable -->
                <table class="sortable">
                    <thead>
                        <tr>
                            <th>C&oacute;digo</th>
                            <th>Curso</th>
                            <th>Requisitos</th>
                            <th>Ciclo</th>
                            <th>Seleccionar</th>
                        </tr>
                    </thead>
                    <%
                        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                        List<Curso> listCursos = new ArrayList<Curso>();
                        CursoDAO cursoDAO = context.getBean(CursoDAO.class);
                        listCursos = cursoDAO.list();
                        for (Curso curso : listCursos) {
                    %>
                    <tbody>
                        <tr>
                            <td><%= curso.getCodigo()%></td>
                            <td><%= curso.getNombre()%></td>
                            <td><%= curso.getRequisitos()%></td>
                            <td><%= curso.getCiclo()%></td>
                            <td><a id="linkEliminarSeccionDeCurso" href="EliminarSeccion2.jsp?idCurso=<%= curso.getIdCurso()%>"><i class="icon-check"></i></a></td>
                        </tr>                    
                        <%
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