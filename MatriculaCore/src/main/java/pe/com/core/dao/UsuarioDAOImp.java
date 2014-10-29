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
import pe.com.core.model.Usuario;

import org.apache.log4j.Logger;

/**
 *
 * @author zcrome
 */
public class UsuarioDAOImp implements UsuarioDAO {

    private SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(UsuarioDAOImp.class);
    
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
            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public List<Usuario> list() {
        List<Usuario> lista = null;

        try {
            Session session = this.sessionFactory.openSession();
            lista = session.createQuery("from Usuario").list();
            session.close();

        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
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

            LOGGER.error("Sorry, something wrong!", e);
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

            LOGGER.error("Sorry, something wrong!", e);
            return false;
        }

        return true;
    }

    public Usuario get(int id) {
        Usuario usuario = null;

        try {

            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class, id);
            tx.commit();
            session.close();

        } catch (Exception e) {

            LOGGER.error("Sorry, something wrong!", e);

        }
        return usuario;
    }

    public Usuario iniciarSesion(String pUsuario, String pClave) {
        List<Usuario> lista = null;
        try {
            Session session = this.sessionFactory.openSession();
            lista = session.createQuery("from Usuario u where u.usuario='"+pUsuario+"' and u.clave='"+pClave+"'").list();
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

}
