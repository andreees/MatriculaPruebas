<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.com.core.dao.CursoDAO"%>
<%@page import="pe.com.core.model.Curso"%>
<%@page import="pe.com.web.matriculaweb.util.ConstantesWeb"%>
<%@page import="pe.com.web.matriculaweb.bean.UsuarioBean"%>
<%    
    UsuarioBean usuarioBean;
    if (session.getAttribute(ConstantesWeb.USUARIO_INICIO) == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuarioBean = (UsuarioBean) session.getAttribute(ConstantesWeb.USUARIO_INICIO);
        if (!usuarioBean.getPrivilegio().equalsIgnoreCase(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR)) {
            response.sendRedirect("error.jsp?mensaje=No tienes privilegios de acceso");
        }
    }
%>
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
        <%
            boolean Exito=Boolean.parseBoolean(request.getParameter("eee"));
            int C=Integer.parseInt(request.getParameter("C"));
            Curso curso;
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            CursoDAO cursoDAO = context.getBean(CursoDAO.class);
            curso= cursoDAO.get(C);
        %>
        <div id="Contenedor">
            <%@include file="template/CabeceraT.jsp" %>
            <%@include file="template/MenuLateralT.jsp" %>
            <div id="ContenidoCentral">
                <h3 id="MensajeBienvenida">Modificar Curso</h3><br>
                <div style="padding-left: 20%">
                    
                    <form name="formCrearCurso" action="ModificarCursoS" method="POST">
                        <input name="txtIdCurso" type="text" value="<%=curso.getIdCurso()%>" style="visibility: hidden"/>
                        <table style="width: 60%">
                            <tr>
                                <td>
                                    <label for="txtNombre">Nombre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(Ej: Lenguaje1)</span></label>
                                </td>
                                <td>
                                    <input name="txtNombre" type="text" required="" value="<%=curso.getNombre()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCodigo">Codigo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(Ej: HU23)</span></label>
                                </td>
                                <td>
                                    <input name="txtCodigo" type="text" required="" value="<%=curso.getCodigo()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCreditos">Creditos&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(Ej: 3)</span></label>
                                </td>
                                <td>
                                    <input name="txtCreditos" type="number" required="" value="<%=curso.getCreditos()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtRequisitos">Requisitos&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(Ej: HU20)</span></label>
                                </td>
                                <td>
                                    <input name="txtRequisitos" required="" type="text" value="<%=curso.getRequisitos()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCiclo">Ciclo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(Ej: 2)</span></label>
                                </td>
                                <td>
                                    <input name="txtCiclo" type="number" required="" value="<%=curso.getCiclo()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btnModificarCurso" type="submit" value="Modificar Curso" /></td>
                            </tr>
                        </table>
                    </form>
                    <%if(Exito)
                    {
                    %>
                        <!-- Success -->
                        <div class="notice success"><i class="icon-ok icon-large"></i><label id="lblMensaje">El curso ha sido modificado correctamente.</label> 
                        <a href="#close" class="icon-remove"></a></div>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
