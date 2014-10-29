/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.com.core.model.Alumno;
import org.apache.log4j.Logger;
/**
 *
 * @author zcrome
 */
public class AlumnoDAOImp implements AlumnoDAO{
    
    private SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(AlumnoDAOImp.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Alumno alumno) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(alumno);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public List<Alumno> list() {
       List<Alumno> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Alumno").list();
          session.close();
          
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
	return lista;
    }

    public boolean update(Alumno alumno) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(alumno);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
        
            LOGGER.error("Sorry, something wrong!", e);
            return false;
        }
        
        return true;
    }

    public boolean delete(Alumno alumno) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(alumno);
            tx.commit();
            session.close();
            
        } catch (Exception e) {            
            LOGGER.error("Sorry, something wrong!", e);
            return false;
        }
        
        return true;
    }

    public Alumno get(int id) {
        Alumno alumno = null;
        
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            alumno = (Alumno)session.get(Alumno.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            LOGGER.error("Sorry, something wrong!", e);
            
        }
        return alumno;   
    }
    
    public Alumno iniciarSesionAlumno(int codigoUsuario) {
        Alumno alumno = null;
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            List<Alumno> listAlumnos = new ArrayList<Alumno>();
            AlumnoDAO aDAO = context.getBean(AlumnoDAO.class);
            listAlumnos = aDAO.list();
            for (Alumno alum : listAlumnos) {
                if (alum.getIdUsuario() == codigoUsuario) {
                    alumno = alum;
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
        return alumno;
    }
}
