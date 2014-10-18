package pe.com.web.matriculaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.com.core.dao.*;
import pe.com.core.model.*;

@WebServlet(name = "ModificarCursoS", urlPatterns = {"/ModificarCursoS"})
public class ModificarCursoS extends HttpServlet {

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
        
        boolean b=false;
        
        Curso curso=new Curso();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        curso.setIdCurso(Integer.parseInt(request.getParameter("txtIdCurso")));
        curso.setNombre(request.getParameter("txtNombre"));
        curso.setCodigo(request.getParameter("txtCodigo"));
        curso.setCreditos(Integer.parseInt(request.getParameter("txtCreditos")));
        curso.setRequisitos(request.getParameter("txtRequisitos"));
        curso.setCiclo(Integer.parseInt(request.getParameter("txtCiclo")));
        
        if(cursoDAO.update(curso))
            b=true;
        
        response.sendRedirect("ModificarCurso2.jsp?eee="+b+"&C="+curso.getIdCurso());
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
