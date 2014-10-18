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
        <title>Cursos - Listar</title>
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
    </head>
    <body>
        <div id="Contenedor">
            <%@include file="template/CabeceraT.jsp" %>
            <div id="MenusLaterales">
                <label>Seleccione una opción: </label>
                <br><br>
                <!-- Menu Vertical Left -->
                <ul class="menu vertical">
                    <li class="current"><a href="">Cursos</a>
                        <ul>
                            <li><a href="ListarCurso.jsp">Listar Cursos</a></li>
                            <li><a href="">Crear Curso</a></li>
                            <li><a href="">Modificar Curso</a></li>
                            <li><a href="">Eliminar Curso</a></li>
                        </ul>
                    </li>
                    <li><a href="">Secciones</a>
                        <ul>
                            <li><a href="">Listar Secciones</a></li>
                            <li><a href="">Crear Seccion</a></li>
                            <li><a href="">Modificar Seccion</a></li>
                            <li><a href="">Eliminar Seccion</a></li>
                        </ul>
                    </li>
                
                </ul>
            </div>
            <div id="ContenidoCentral">
                <h3 id="MensajeBienvenida">Listado de Cursos</h3><br>
                <!-- Table sortable -->
                <table cellspacing="0" cellpadding="0" class="sortable">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Creditos</th>
                        </tr>
                    </thead>
                    <%
                        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		        List<Curso> ListaDeCursos = new ArrayList<Curso>();
                        CursoDAO cDAO= context.getBean(CursoDAO.class);
                        ListaDeCursos=cDAO.list();
                        for(Curso C: ListaDeCursos)
                        {
                    %>
                    <tbody>
                        <tr>
                            <td><%= C.getCodigo()%></td>
                            <td><%= C.getNombre()%></td>
                            <td><%= C.getCreditos()%></td>
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
