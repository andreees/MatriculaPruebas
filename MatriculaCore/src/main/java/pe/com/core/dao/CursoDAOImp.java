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

import pe.com.core.model.Curso;
/**
 *
 * @author zcrome
 */
public class CursoDAOImp implements CursoDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Curso curso) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(curso);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> list() {
        List<Curso> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Curso").list();
          session.close();
          
            
        } catch (Exception e) {
          }
	return lista;
    }

    public boolean update(Curso curso) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(curso);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public boolean delete(Curso curso) {
        try {
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(curso);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    public Curso get(int id) {
        Curso curso = null;
        
        try {           
            
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            curso = (Curso)session.get(Curso.class, id);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        return curso;   
    }
    
    
}
