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
import pe.com.core.model.Administrador;
import org.apache.log4j.Logger;


/**
 *
 * @author zcrome
 */
public class AdministradorDAOImp implements AdministradorDAO{

    private SessionFactory sessionFactory;
    private final static Logger LOGGER = Logger.getLogger(AdministradorDAOImp.class);

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
            LOGGER.error("Sorry, something wrong!", e);
        }
    }

    public List<Administrador> list() {
        List<Administrador> lista = null;
        
        try {
          Session session = this.sessionFactory.openSession();
          lista = session.createQuery("from Administrador").list();
          session.close();
          
            
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
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
            
            LOGGER.error("Sorry, something wrong!", e);
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
            
            LOGGER.error("Sorry, something wrong!", e);
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
            
            LOGGER.error("Sorry, something wrong!", e);
            
        }
        return administrador;   
    }
    
    public Administrador iniciarSesionAdministrador(int codigoUsuario){
        Administrador administrador = null;
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            List<Administrador> listAdministradors = new ArrayList<Administrador>();
            AdministradorDAO aDAO = context.getBean(AdministradorDAO.class);
            listAdministradors = aDAO.list();
            for (Administrador admin : listAdministradors) {
                if (admin.getIdUsuario() == codigoUsuario ) {
                    administrador = admin;
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Sorry, something wrong!", e);
        }
        return administrador;
    }
}
