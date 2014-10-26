<%-- 
    Document   : newjspPrincipalAlumno
    Created on : 22/10/2014, 04:30:15 PM
    Author     : Roy
--%>

<%@page import="pe.com.core.dao.ClaseDAO"%>
<%@page import="pe.com.core.dao.SeccionDAO"%>
<%@page import="pe.com.core.model.Clase"%>
<%@page import="pe.com.core.model.Seccion"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.core.dao.CursoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula - Alumno</title>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script type="text/cjs">
            
            
        </script> 
    </head>
    <body>
        <div id="Contenedor">
            <!--<%@include file="template/CabeceraT.jsp" %>-->
            <div id="ContenidoCentral">
                
                <h5 id="MensajeBienvenida">Seleccione los cursos y secciones en los que desea matricularse</h5><br>
                <form name="formMatricula" action="RegistrarMatriculaS" method="POST">
                <table>
                    <% 
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                    List<Curso> ListaDeCursos = new ArrayList<Curso>();
                    List<Seccion> ListaDeSecciones = new ArrayList<Seccion>();
                    List<Clase> ListaDeClases = new ArrayList<Clase>();
                    CursoDAO cDAO= context.getBean(CursoDAO.class);
                    SeccionDAO sDAO;
                    ClaseDAO ccDAO;

                    ListaDeCursos=cDAO.list();
                    int i=0;
                    for(Curso C: ListaDeCursos)
                    {
                    %>
                    
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="ck<%=i%>"><%=C.getNombre() %></th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            <%
                            sDAO= context.getBean(SeccionDAO.class);
                            ListaDeSecciones=sDAO.listXIdCurso(C.getIdCurso());         
                            for(Seccion S: ListaDeSecciones)
                            {
                            %>
                        <tr>
                            <td><input type="radio" name="rb<%=i%>" value="<%=S.getIdSeccion()%>" ><%=S.getCodigo()%> 
                                (
                                        <%
                                        ccDAO = context.getBean(ClaseDAO.class);
                                        ListaDeClases=ccDAO.listXIdSeccion(S.getIdSeccion());
                                        
                                        for(Clase CC: ListaDeClases)
                                        {
                                        %>
                                        <%=CC.getDia() %> <%=CC.getHoraInicio() %> - <%=CC.getHoraFin()%> : <%=CC.getCodigo()%>
                                        
                                         &nbsp;&nbsp;&nbsp;

                                        <%
                                        }
                                        %>
                                        <%=S.getProfesor()%>
                                )<br>
                        </tr>
                            <%
                            }
                            %>
                    </tbody>
                    <%
                    i++;
                    }
                    %>
                </table>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Grabar Matricula" />
            </form>
            </div>
        </div>
    </body>
</html>
