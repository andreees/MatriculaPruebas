package pe.com.web.matriculaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.com.core.dao.*;
import pe.com.core.model.*;
import pe.com.web.matriculaweb.bean.UsuarioBean;
import pe.com.web.matriculaweb.util.ConstantesWeb;

@WebServlet(name = "SolicitarAperturaS", urlPatterns = {"/SolicitarAperturaS"})
public class SolicitarAperturaS extends HttpServlet {

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
                
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
                String sMotivoApertura=request.getParameter("MotivoApertura");
                String sCodigoCurso=request.getParameter("CodigoCurso");
                if(sMotivoApertura.trim().equals("") || sCodigoCurso.trim().equals("")){
                    
                    
                    response.sendRedirect("SolicitarApertura.jsp?eee="+2);
                }
                else{
                
                    SolicitudDAO solicitudDAO = context.getBean(SolicitudDAO.class);
                
                    Solicitud solicitud=new Solicitud();
                    
                    HttpSession sesion=request.getSession();
                    
                    UsuarioBean usuario=(UsuarioBean)sesion.getAttribute(ConstantesWeb.USUARIO_INICIO);
                    
                    solicitud.setIdAlumno(usuario.getIdAlumno());
                    solicitud.setIdCurso(Integer.parseInt(sCodigoCurso));
                    solicitud.setMotivo(request.getParameter("MotivoApertura"));
                    
                    try{
                    
                        solicitudDAO.save(solicitud);
                   
                    }
                    catch(Exception e)
                    {
                        
                        response.sendRedirect("SolicitarApertura.jsp?eee="+2);
                        e.printStackTrace();
                        
                    }
                    
                    response.sendRedirect("SolicitarApertura.jsp?eee="+1);
                    
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
