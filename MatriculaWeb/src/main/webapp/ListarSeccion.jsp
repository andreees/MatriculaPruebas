<%-- 
    Document   : ListarSeccion
    Created on : 20/10/2014, 03:39:46 PM
    Author     : Roy Taza Rojas
--%>

<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.com.core.dao.*"%>
<%@page import="pe.com.core.model.*"%>
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
        <title>Secciones - Listar</title>
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
                <h3 id="MensajeBienvenida">Listado de Secciones</h3><br>
                <p>A continuación se muestran las secciones existentes con el 
                    respectivo curso al que pertenece</p>
                <!-- Table sortable -->
                <table class="sortable">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Profesor</th>
                            <th>Curso</th>
                        </tr>
                    </thead>
                    <%
                        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                        List<Curso> listCursos = new ArrayList<Curso>();
                        List<Seccion> listSeccions = new ArrayList<Seccion>();
                        CursoDAO cursoDAO = context.getBean(CursoDAO.class);
                        ClaseDAO claseDAO = context.getBean(ClaseDAO.class);
                        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
                        listCursos = cursoDAO.list();
                        listSeccions = seccionDAO.list();
                        for (Seccion seccion : listSeccions) {
                    %>
                    <tbody>
                        <tr>
                            <td><%= seccion.getCodigo()%></td>
                            <td><%= seccion.getProfesor()%></td>
                            <td>
                                <%
                                    for (Curso curso : listCursos) {
                                        if (curso.getIdCurso() == seccion.getIdcurso()) {
                                %>
                                <%= curso.getCodigo()%> - <%= curso.getNombre()%>
                                <%
                                            break;
                                        }
                                    }
                                %>
                            </td>
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