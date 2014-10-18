<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos - Crear</title>
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
                <h3 id="MensajeBienvenida">Crear Curso</h3><br>
                <div style="padding-left: 20%">
                    
                    <form name="formCrearCurso" action="CrearCursoS" method="POST">
                        <table style="width: 40%">
                            <tr>
                                <td>
                                    <label for="txtNombre">Nombre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(A-Z)</span></label>
                                </td>
                                <td>
                                    <input name="txtNombre" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCodigo">Codigo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(A-Z,1-9)</span></label>
                                </td>
                                <td>
                                    <input name="txtCodigo" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCreditos">Creditos&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(1-4)</span></label>
                                </td>
                                <td>
                                    <input name="txtCreditos" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtRequisitos">Requisitos&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(A-Z)</span></label>
                                </td>
                                <td>
                                    <input name="txtRequisitos" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="txtCiclo">Ciclo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="right">(A-Z)</span></label>
                                </td>
                                <td>
                                    <input name="txtCiclo" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Crear Curso" /></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
