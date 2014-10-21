<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
            <%@include file="template/MenuLateralT.jsp" %>
            <div id="ContenidoCentral">
                <h3 id="MensajeBienvenida">Solicitud de Apertura de Curso</h3><br>
                <div style="padding-left: 20%">
                    
                    <form name="formCrearCurso" action="SolicitarAperturaS" method="POST">
                        <table style="width: 40%">
                            <tr>
                                <td>
                                    <label for="CodigoCurso">Curso</label>
                                </td>
                                <td>
                                    <select name="CodigoCurso">
                                        <option value="34424">Pruebas</option>
                                        <option value="2">Otro</option>
                                        <option value="3">Otro2</option>
                                        <option value="4">Otro3</option>
                                    </select>
         
                                </td>
                            <tr>
                                <td>
                                    <label for="MotivoApertura">Codigo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(A-Z,1-9)</span></label>
                                </td>
                                <td>
                                    <textarea name="MotivoApertura" rows="6" cols="100"></textarea>
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
