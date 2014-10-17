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

import pe.com.core.model.Administrador;
/**
 *
 * @author zcrome
 */
public class AdministradorDAOImp implements AdministradorDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Administrador administrador) {
         try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(administrador);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Administrador> list() {
        List<Administrador> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Administrador").list();
          session.close();
          
            
        } catch (Exception e) {
          }
	return lista;
    }

    public boolean update(Administrador administrador) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(administrador);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public boolean delete(Administrador administrador) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(administrador);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public Administrador get(int id) {
       Administrador administrador = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            administrador = (Administrador)session.get(Administrador.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return administrador;   
    }
    
}
