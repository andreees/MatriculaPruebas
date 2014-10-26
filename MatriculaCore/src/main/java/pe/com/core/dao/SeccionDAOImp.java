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

import pe.com.core.model.Seccion;
import org.apache.log4j.Logger;


/**
 *
 * @author zcrome
 */

public class SeccionDAOImp implements SeccionDAO {
    
    private SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(SeccionDAOImp.class);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Seccion s) {
        
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
            session.close();
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);

        }
        
    }

    public List<Seccion> list() {
        
        List<Seccion> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Seccion").list();
          session.close();
          
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);

          }
	return lista;
    }

    public List<Seccion> listXIdCurso(int idCurso) {
        
        List<Seccion> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Seccion where idcurso="+idCurso).list();
          session.close();
          
            
        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);

        }
	return lista;
    }
    
    
    public boolean update(Seccion s) {
        
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(s);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            

            LOGGER.error("Sorry, something wrong!", e);

            return false;
        }
        
        return true;
        
    }

    public boolean delete(Seccion s) {
        
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(s);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            

            LOGGER.error("Sorry, something wrong!", e);

            return false;
        }
        
        return true;
    }
    
    public Seccion get(int id) {
        
        Seccion seccion = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            seccion = (Seccion)session.get(Seccion.class, id);
            tx.commit();
            session.close();
            

        } catch (Exception e) {            
            LOGGER.error("Sorry, something wrong!", e);            

        }
        return seccion;        
    }
        
}
