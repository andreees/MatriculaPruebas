<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos - Modificar</title>
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
                <h3 id="MensajeBienvenida">Modificar Cursos</h3><br>
                <!-- Table sortable -->
                <table class="sortable">
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
