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
                <h3 id="MensajeBienvenida">Listado de Secciones</h3><br>
                <p>A continuación se muestran las secciones existentes con el 
                    respectivo curso al que pertenece</p>
                <!-- Table sortable -->
                <table class="sortable">
                    <thead>
                        <tr>
                            <th>Seccion</th>
                            <th>Curso</th>
                        </tr>
                    </thead>
                    <%
                        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                        List<Curso> listCursos = new ArrayList<Curso>();
                        List<Clase> listClases = new ArrayList<Clase>();
                        List<Seccion> listSeccions = new ArrayList<Seccion>();
                        CursoDAO cursoDAO = context.getBean(CursoDAO.class);
                        ClaseDAO claseDAO = context.getBean(ClaseDAO.class);
                        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
                        listCursos = cursoDAO.list();
                        listSeccions = seccionDAO.list();
                        for (Clase clase : listClases) {
                    %>
                    <tbody>
                        <tr>
                            <td>
                                <%
                                    for (Curso curso : listCursos) {
                                        if (clase.getIdCurso() == curso.getIdCurso()) {
                                %>
                                <%= curso.getNombre()%>
                                <%
                                            break;
                                        }
                                    }
                                %>
                            </td>
                            <td>
                                <%
                                    for (Seccion seccion : listSeccions) {
                                        if (clase.getIdSeccion() == seccion.getIdSeccion()) {
                                %>
                                <%= seccion.getCodigo()%>
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
