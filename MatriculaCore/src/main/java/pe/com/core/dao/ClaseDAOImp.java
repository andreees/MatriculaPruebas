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
import pe.com.core.model.Clase;
import org.apache.log4j.Logger;

/**
 *
 * @author zcrome
 */
public class ClaseDAOImp implements ClaseDAO{
    
    private SessionFactory sessionFactory;

    private final static Logger LOGGER = Logger.getLogger(ClaseDAOImp.class);    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Clase clase) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(clase);
            tx.commit();
            session.close();
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public List<Clase> list() {
        List<Clase> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Clase").list();
          session.close();
          
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);
          }
	return lista;
    }
    
    public List<Clase> listXIdSeccion(int idSeccion) {
        List<Clase> lista = null;
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Clase where idseccion="+idSeccion).list();
          session.close();
          
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);

          }
	return lista;
    }

    public boolean update(Clase clase) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(clase);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            

            LOGGER.error("Sorry, something wrong!", e);

            return false;
        }
        
        return true;
    }

    public boolean delete(Clase clase) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(clase);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            

            LOGGER.error("Sorry, something wrong!", e);

            return false;
        }
        
        return true;
    }

    public Clase get(int id) {
        Clase clase = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            clase = (Clase)session.get(Clase.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            

            LOGGER.error("Sorry, something wrong!", e);

            
        }
        return clase;   
    }
    
    
}
