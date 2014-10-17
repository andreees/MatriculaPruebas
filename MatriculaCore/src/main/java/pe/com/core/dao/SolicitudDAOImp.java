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

import pe.com.core.model.Solicitud;
/**
 *
 * @author zcrome
 */
public class SolicitudDAOImp implements SolicitudDAO{
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Solicitud solicitud) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(solicitud);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Solicitud> list() {
         List<Solicitud> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Solicitud").list();
          session.close();
          
            
        } catch (Exception e) {
          }
	return lista;
    }

    public boolean update(Solicitud solicitud) {
       try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(solicitud);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public boolean delete(Solicitud solicitud) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(solicitud);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public Solicitud get(int id) {
        Solicitud solicitud = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            solicitud = (Solicitud)session.get(Solicitud.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return solicitud;   
    }
    
    
    
}
