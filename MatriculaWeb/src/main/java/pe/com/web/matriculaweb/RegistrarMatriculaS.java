/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.web.matriculaweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.core.dao.CursoDAO;
import pe.com.core.dao.MatriculaDAO;
import pe.com.core.dao.SolicitudDAO;
import pe.com.core.model.Curso;
import pe.com.core.model.Matricula;
import pe.com.core.model.Solicitud;
import pe.com.web.matriculaweb.bean.UsuarioBean;
import pe.com.web.matriculaweb.util.ConstantesWeb;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "RegistrarMatriculaS", urlPatterns = {"/RegistrarMatriculaS"})
public class RegistrarMatriculaS extends HttpServlet{
    private final static Logger LOGGER = Logger.getLogger(RegistrarMatriculaS.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        

        CursoDAO cDAO= context.getBean(CursoDAO.class);
        MatriculaDAO mDAO= context.getBean(MatriculaDAO.class);
        HttpSession sesion=request.getSession();
        Matricula m;
        String ck,rb;
                    
       UsuarioBean usuario=(UsuarioBean)sesion.getAttribute(ConstantesWeb.USUARIO_INICIO);
        cDAO.list();
        
        DateTime dt;
        boolean modificado=false;
        try{
            for(int i=0;i<cDAO.list().size();i++){
                ck=request.getParameter("ck"+i);
                if(ck!=null){//check en curso - Agregar
                    rb=request.getParameter("rb"+i);
                    if(rb!=null){//check en seccion - Agregar
                        Curso c=cDAO.get(i+1);
                        m=mDAO.getXIdCursoXIdAlumno(c.getIdCurso(),usuario.getIdAlumno());
                        dt=DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT-5:00")));
                        if(m!=null){//existe registro para alumno y curso en matricula
                            if(m.getIdSeccion()!=Integer.parseInt(rb)){
                                modificado=true;
                                m.setIdSeccion(Integer.parseInt(rb));//modificar
                                m.setHoramatricula(dt.getHourOfDay());
                                mDAO.update(m);
                                //Registro de Matricula Modificado
                            }
                        }else{//NO existe registro para Curso y Alumno
                            m=new Matricula();
                            m.setHoramatricula(dt.getHourOfDay());
                            m.setFechamatricula(dt.toDate());
                            m.setIdCurso(i+1);
                            m.setIdSeccion(Integer.parseInt(rb));
                            m.setIdAlumno(usuario.getIdAlumno());
                            mDAO.save(m);
                            //Registro de Matricula Insertado
                            modificado=true;
                        }
                        
                    }
                }else{//No check curso -- Eliminar
                    Curso c=cDAO.get(i+1);
                    m=mDAO.getXIdCursoXIdAlumno(c.getIdCurso(),usuario.getIdAlumno());
                    if(m!=null){//si alumno está registrado en curso
                        mDAO.delete(m);
                        //Registro de Matricula Eliminado
                        modificado=true;
                    }
                }
            }
        
        }catch(Exception e){
            LOGGER.error("Sorry, something wrong!", e);
            response.sendRedirect("PrincipalAlumno.jsp?eee="+2);
        }
        
        if(modificado){
            response.sendRedirect("PrincipalAlumno.jsp?eee="+1);
        }else{
            response.sendRedirect("PrincipalAlumno.jsp?eee="+2);
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
    
    
    

