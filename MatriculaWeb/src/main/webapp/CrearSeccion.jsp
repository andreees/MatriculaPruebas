<%-- 
    Document   : CrearSeccion
    Created on : 20/10/2014, 03:39:26 PM
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
                <h3 id="MensajeBienvenida">Crear Seccion</h3><br>
                <p>Haga clic en el curso que desea crear una secci&oacute;n</p>
                <!-- Table sortable -->
                <table class="sortable">
                    <thead>
                        <tr>
                            <th>C&oacute;digo</th>
                            <th>Curso</th>
                            <th>Requisitos</th>
                            <th>Ciclo</th>
                            <th>Agregar</th>
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
                            <td><a href="#"><img src="#" alt="Agregar"></a></td>
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
