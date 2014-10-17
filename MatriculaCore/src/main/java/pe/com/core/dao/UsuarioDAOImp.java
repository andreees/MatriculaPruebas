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

import pe.com.core.model.Usuario;
/**
 *
 * @author zcrome
 */
public class UsuarioDAOImp implements UsuarioDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Usuario usuario) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(usuario);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> list() {
        List<Usuario> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Usuario").list();
          session.close();
          
            
        } catch (Exception e) {
          }
	return lista;
    }

    public boolean update(Usuario usuario) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public boolean delete(Usuario usuario) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(usuario);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public Usuario get(int id) {
        Usuario usuario = null;
        
        try {
            
            
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            usuario = (Usuario)session.get(Usuario.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return usuario;     
    }
    
    
    
}
