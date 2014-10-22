/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.web.matriculaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.core.dao.AdministradorDAO;
import pe.com.core.dao.AlumnoDAO;
import pe.com.core.dao.UsuarioDAO;
import pe.com.core.model.Administrador;
import pe.com.core.model.Alumno;
import pe.com.core.model.Usuario;
import pe.com.web.matriculaweb.util.Encryptor;

/**
 *
 * @author Roy
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String mensaje = "";
        boolean iniciarSesionNow = false;
        try {
            String sUsuario = request.getParameter("txtUsuario");
            String sClave = Encryptor.encrypt(request.getParameter("txtClave"));

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            UsuarioDAO uDAO = context.getBean(UsuarioDAO.class);
            Usuario user = uDAO.iniciarSesion(sUsuario, sClave);
            
            if (user != null) {
                // El usuario existe, comprobar que privilegio tiene
                // Comprobar si es Alumno
                AlumnoDAO alumnoDAO = context.getBean(AlumnoDAO.class);
                Alumno alumno = alumnoDAO.iniciarSesionAlumno(user.getIdUsuario());
                if (alumno != null) {
                    // Es Alumno
                    url = "PrincipalAlumno.jsp";
                    mensaje = "A Login successful";
                    iniciarSesionNow = true;
                } else {
                    AdministradorDAO administradorDAO = context.getBean(AdministradorDAO.class);
                    Administrador administrador = administradorDAO.iniciarSesionAdministrador(user.getIdUsuario());
                    if (administrador != null) {
                        // Es Administrador
                        url = "PrincipalAdministrador.jsp";
                        mensaje = "A Login successful";
                        iniciarSesionNow = true;
                    } else {
                        // Usuaario sin privilegios
                        url = "index.jsp";
                        mensaje = "El usuario no tiene privilegios asignados";
                    }
                }
            } else {
                // El usuario no existe
                url = "index.jsp";
                mensaje = "Usuario y/o clave incorrecto";
            }
            if (iniciarSesionNow) {
                // Crear la sesion

                response.sendRedirect(url);
            } else {
                response.sendRedirect(url + "?mensaje=" + mensaje);
            }
        } catch (Exception e) {
            url = "error.jsp";
            mensaje = e.getMessage();
            response.sendRedirect(url + "?mensaje=" + mensaje);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
