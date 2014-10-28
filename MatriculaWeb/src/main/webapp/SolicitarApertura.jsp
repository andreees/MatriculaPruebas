
<%@page import="pe.com.core.dao.CursoDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%    
    UsuarioBean usuarioBean;
    if (session.getAttribute(ConstantesWeb.USUARIO_INICIO) == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuarioBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
        if (!usuarioBean.getPrivilegio().equalsIgnoreCase(ConstantesWeb.PRIVILEGIO_ALUMNO)) {
            response.sendRedirect("error.jsp?mensaje=No tienes privilegios de acceso");
        }
    }
%>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula - Solicitar Apertura de Salon</title>
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
    </head>
    <body>
        <%
            String r= request.getParameter("eee");
            int Exito=0;
            if(r!=null){
                Exito=Integer.parseInt(r);
            }
            
        %>
        <div id="Contenedor">
            <%@include file="template/CabeceraT.jsp" %>
            <div id="ContenidoCentral">
                <h5 id="MensajeBienvenida">Solicitud de Apertura de Curso</h5><br>
                <div style="padding-left: 10%">
                    
                    <form name="formSolicitarApertura" action="SolicitarAperturaS" method="POST">
                        <table style="width: 40%">
                            <tr>
                                <td>
                                    <label for="CodigoCurso">Curso</label>
                                </td>
                                <td>
                                    <select name="CodigoCurso" required="true">
                                        <%
                                            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                                            List<Curso> listCursos = new ArrayList<Curso>();
                                            CursoDAO cursoDAO = context.getBean(CursoDAO.class);
                                            listCursos = cursoDAO.list();
                                            for (Curso curso : listCursos) {
                                                %>
                                                <option value="<%=curso.getIdCurso()%>"><%= curso.getNombre()%></option>
                                                <%
                                            }     
                                        %>

                                    </select>
         
                                </td>
                            <tr>
                                <td>
                                    <label for="MotivoApertura">Motivo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td>
                                    <textarea name="MotivoApertura" rows="6" cols="100" required="true"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Enviar Solicitud" /></td>
                            </tr>
                        </table>
                    </form>
                    <%if(Exito==1){
                    %>
                        <!-- Success -->
                        <div class="notice success"><i class="icon-ok icon-large"></i> Se envió la solicitud de Apertura de Curso! 
                        <a href="#close" class="icon-remove"></a></div>
                    <%
                    }
                    else if(Exito==2){
                    %>
                        <!-- NotSuccess -->
                        <div class="notice warning"><i class="icon-remove icon-large"></i> La solicitud es invalida 
                        <a href="#close" class="icon-remove"></a></div>
                    <%
                    }
                    else {
                    
                    }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
