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
import pe.com.core.dao.ClaseDAO;
import pe.com.core.dao.SeccionDAO;
import pe.com.core.model.Clase;
import pe.com.core.model.Seccion;
import pe.com.web.matriculaweb.util.ConstantesWeb;

/**
 *
 * @author Roy
 */
@WebServlet(name = "ControllerSeccion", urlPatterns = {"/ControllerSeccion"})
public class ControllerSeccion extends HttpServlet {

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
        String accion = request.getParameter("action");

        switch (accion) {
            case ConstantesWeb.CREAR_SECCION:
                this.CrearSeccion(request, response);
                break;
            case ConstantesWeb.MODIFICAR_SECCION:
                this.ModificarSeccion(request, response);
                break;
            case ConstantesWeb.ELIMINAR_SECCION:
                this.EliminarSeccion(request, response);
                break;
        }
    }

    protected void CrearSeccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String mensaje = "";
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
            ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

            Seccion seccion = new Seccion();
            Clase clase = new Clase();
            seccion.setCodigo(request.getParameter("txtCodigoSeccion"));
            seccion.setProfesor(request.getParameter("txtProfesor"));
            seccion.setIdcurso(Integer.parseInt(request.getParameter("idCurso")));
            clase.setCodigo(request.getParameter("txtSalon"));
            clase.setDia(request.getParameter("cbDia"));
            clase.setHoraInicio(Integer.parseInt(request.getParameter("txtHoraInicio")));
            clase.setHoraFin(Integer.parseInt(request.getParameter("txtHoraFin")));
            clase.setTipoClase(request.getParameter("cbTipoClase"));
            clase.setIdSeccion(seccionDAO.saveAndReturnId(seccion));
            claseDAO.save(clase);

            url = "CrearSeccion3.jsp";
            mensaje = "success";
            response.sendRedirect(url + "?mensaje=" + mensaje);
        } catch (Exception e) {
            url = "error.jsp";
            mensaje = e.getMessage();
            response.sendRedirect(url + "?mensaje=" + mensaje);
        }
    }

    protected void ModificarSeccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String mensaje = "";
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
            ClaseDAO claseDAO = context.getBean(ClaseDAO.class);
            
            int idSeccion = Integer.parseInt(request.getParameter("idSeccion"));
            int idClase = Integer.parseInt(request.getParameter("idClase"));

            Seccion seccion = seccionDAO.get(idSeccion);
            Clase clase = claseDAO.get(idClase);
            seccion.setCodigo(request.getParameter("txtCodigoSeccion"));
            seccion.setProfesor(request.getParameter("txtProfesor"));
            clase.setCodigo(request.getParameter("txtSalon"));
            clase.setDia(request.getParameter("cbDia"));
            clase.setHoraInicio(Integer.parseInt(request.getParameter("txtHoraInicio")));
            clase.setHoraFin(Integer.parseInt(request.getParameter("txtHoraFin")));
            clase.setTipoClase(request.getParameter("cbTipoClase"));
            
            seccionDAO.update(seccion);
            claseDAO.update(clase);

            url = "ModificarSeccion4.jsp";
            mensaje = "success";
            response.sendRedirect(url + "?mensaje=" + mensaje);
        } catch (Exception e) {
            url = "error.jsp";
            mensaje = e.getMessage();
            response.sendRedirect(url + "?mensaje=" + mensaje);
        }
    }
    
    protected void EliminarSeccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String mensaje = "";
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
            ClaseDAO claseDAO = context.getBean(ClaseDAO.class);
            
            int idSeccion = Integer.parseInt(request.getParameter("idSeccion"));
            int idClase = Integer.parseInt(request.getParameter("idClase"));
            
            Clase clase = claseDAO.get(idClase);
            claseDAO.delete(clase);
            
            Seccion seccion = seccionDAO.get(idSeccion);
            seccionDAO.delete(seccion);

            url = "EliminarSeccion3.jsp";
            mensaje = "success";
            response.sendRedirect(url + "?mensaje=" + mensaje);
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
