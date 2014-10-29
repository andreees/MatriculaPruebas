/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.com.core.model.Matricula;
import org.apache.log4j.Logger;
/**
 *
 * @author zcrome
 */
public class MatriculaDAOImp implements MatriculaDAO{

    private SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(MatriculaDAOImp.class);    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Matricula matricula) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(matricula);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public List<Matricula> list() {
         List<Matricula> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Matricula").list();
          session.close();
          
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
          }
	return lista;
    }

    public Matricula getXIdCursoXIdAlumno(int idCurso,int idAlumno) {
         List<Matricula> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Matricula where idcurso="+idCurso+" and idalumno="+idAlumno+" and fechamatricula=CURDATE()").list();
          session.close();
          
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
        if(!lista.isEmpty()){
            return lista.get(0);
        }else{
            return null;
        }
            
    }
    
    public boolean update(Matricula matricula) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(matricula);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
            return false;
        }
        
        return true;
    }

    public boolean delete(Matricula matricula) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(matricula);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
            return false;
        }
        
        return true;
    }

    public Matricula get(int id) {
        Matricula matricula = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            matricula = (Matricula)session.get(Matricula.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            LOGGER.error("Sorry, something wrong!", e);
            
        }
        return matricula;   
    }
    
}
