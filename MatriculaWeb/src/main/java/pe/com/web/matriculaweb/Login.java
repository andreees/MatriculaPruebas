package pe.com.web.matriculaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.core.dao.AdministradorDAO;
import pe.com.core.dao.AlumnoDAO;
import pe.com.core.dao.UsuarioDAO;
import pe.com.core.model.Administrador;
import pe.com.core.model.Alumno;
import pe.com.core.model.Usuario;
import pe.com.web.matriculaweb.bean.UsuarioBean;
import pe.com.web.matriculaweb.util.ConstantesWeb;
import pe.com.web.matriculaweb.util.Encryptor;

/**
 *
 * @author Roy
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(Login.class);
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
        HttpSession sesion = request.getSession(true);
        UsuarioBean usuarioBean;
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
                    mensaje = "Alumno Login successful";
                    usuarioBean = new UsuarioBean();
                    usuarioBean.setIdUsuario(user.getIdUsuario());
                    usuarioBean.setPrivilegio(ConstantesWeb.PRIVILEGIO_ALUMNO);
                    usuarioBean.setIdAlumno(alumno.getIdAlumno());
                    usuarioBean.setIdAdministrador(0);
                    usuarioBean.setUsuarioLogin(user.getUsuario());
                    usuarioBean.setNombres(alumno.getNombres());
                    usuarioBean.setApellidos(alumno.getApellidos());
                    if (sesion.getAttribute(ConstantesWeb.USUARIO_INICIO) != null) {
                        sesion.removeAttribute(ConstantesWeb.USUARIO_INICIO);
                    }
                    sesion.setAttribute(ConstantesWeb.USUARIO_INICIO, usuarioBean);
                    sesion.setMaxInactiveInterval(60 * 60);
                } else {
                    AdministradorDAO administradorDAO = context.getBean(AdministradorDAO.class);
                    Administrador administrador = administradorDAO.iniciarSesionAdministrador(user.getIdUsuario());
                    if (administrador != null) {
                        // Es Administrador
                        url = "PrincipalAdministrador.jsp";
                        mensaje = "Admin Login successful";
                        usuarioBean = new UsuarioBean();
                        usuarioBean.setIdUsuario(user.getIdUsuario());
                        usuarioBean.setPrivilegio(ConstantesWeb.PRIVILEGIO_ADMINISTRADOR);
                        usuarioBean.setIdAlumno(0);
                        usuarioBean.setIdAdministrador(administrador.getIdAdministrador());
                        usuarioBean.setUsuarioLogin(user.getUsuario());
                        usuarioBean.setNombres(administrador.getNombres());
                        usuarioBean.setApellidos(administrador.getApellidos());
                        if (sesion.getAttribute(ConstantesWeb.USUARIO_INICIO) != null) {
                            sesion.removeAttribute(ConstantesWeb.USUARIO_INICIO);
                        }
                        sesion.setAttribute(ConstantesWeb.USUARIO_INICIO, usuarioBean);
                        sesion.setMaxInactiveInterval(60 * 60);
                    } else {
                        // Usuario sin privilegios
                        url = "index.jsp";
                        mensaje = "El usuario no tiene privilegios asignados";
                    }
                }
            } else {
                // El usuario no existe
                url = "index.jsp";
                mensaje = "Usuario y/o clave incorrecto";
            }
            // Redireccionar
            response.sendRedirect(url + "?mensaje=" + mensaje);
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
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
