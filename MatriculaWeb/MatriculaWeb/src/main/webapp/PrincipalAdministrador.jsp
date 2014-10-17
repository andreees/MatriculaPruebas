<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula - Administrador</title>
        <link rel="stylesheet" href="assets/css/Basico.css" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="assets/js/kickstart.js"></script> <!-- KICKSTART -->
        <link rel="stylesheet" href="assets/css/kickstart.css" media="all" /> <!-- KICKSTART -->
    </head>
    <body>
        <div id="Contenedor">
            <div id="Cabecera">
                <img src="assets/imagenes/logoUPC.png" width="50" height="50" alt="logoUPC"/>
                <label>ADMINISTRACIÓN</label>
                <label id="lblUsuario"></label>
                <input type="submit" value="Cerrar Sesion" name="btnCerrarSesion" />
            </div>
            <div id="MenusLaterales">
                <label>Seleccione una opción: </label>
                <br><br>
                <!-- Menu Vertical Left -->
                <ul class="menu vertical">
                    <li class="current"><a href="">Cursos</a>
                        <ul>
                            <li><a href="">Listar Cursos</a></li>
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
                <h3 id="MensajeBienvenida">Bienvenido Administrador</h3><br>
                <!-- Caption -->
                <img src="assets/imagenes/imagenAdmin.png" width="200" height="200" style="margin-left: 40%"/>
            </div>
        </div>
    </body>
</html>
