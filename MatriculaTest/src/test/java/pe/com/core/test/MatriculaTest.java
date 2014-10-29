/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pe.com.core.dao.CursoDAO;
import pe.com.core.dao.MatriculaDAO;
import pe.com.core.dao.SolicitudDAO;
import pe.com.core.model.Curso;
import pe.com.core.model.Matricula;
import pe.com.core.model.Solicitud;

/**
 *
 * @author Cesar
 */

@Test
public class MatriculaTest {
    private Selenium selenium;
    
    private static boolean cmp( List<Matricula> l1, List<Matricula> l2 ) {
    // make a copy of the list so the original list is not changed, and remove() is supported
        List<Matricula> cp = new ArrayList<Matricula>( l1 );
        for ( Object o : l2 ) {
            if ( !cp.remove( o ) ) {
                return false;
            }
        }
        return cp.isEmpty();
    }
    
    private static boolean cmp2( List<Solicitud> l1, List<Solicitud> l2 ) {
    // make a copy of the list so the original list is not changed, and remove() is supported
        List<Solicitud> cp = new ArrayList<Solicitud>( l1 );
        for ( Object o : l2 ) {
            if ( !cp.remove( o ) ) {
                return false;
            }
        }
        return cp.isEmpty();
    }
    
    
    @BeforeClass
    public void inicioClase() throws Exception{
        selenium = new DefaultSelenium("localhost", 4441, "firefox", 
                "http://localhost:8080/");
        selenium.start();
    }
    
    
    @Test
    public void RegistrarMatricula_Invalido(){
        /*
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	MatriculaDAO mDAO= context.getBean(MatriculaDAO.class);
        List<Matricula> listam1=new ArrayList<Matricula>();
        List<Matricula> listam2=new ArrayList<Matricula>();
        listam1=mDAO.list();
        */
       
        selenium.open("/MatriculaWeb/");
        selenium.type("name=txtUsuario", "cpalma");
        selenium.type("name=txtClave", "cesar");
        selenium.click("name=btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.click("name=btnGrabarMatricula");
        selenium.waitForPageToLoad("30000");
        assertEquals(selenium.getText("css=div.notice.warning"), "No se ha grabado la matricula");
        //listam2=mDAO.list();
        //assertEquals(true,cmp(listam1,listam2));
    }
    
    
    @Test
    public void RegistrarMatricula_Valido(){
        /*
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	MatriculaDAO mDAO= context.getBean(MatriculaDAO.class);
        List<Matricula> listam1=new ArrayList<Matricula>();
        List<Matricula> listam2=new ArrayList<Matricula>();
        listam1=mDAO.list();
        */
       
        selenium.open("/MatriculaWeb/");
        selenium.type("name=txtUsuario", "cpalma");
        selenium.type("name=txtClave", "cesar");
        selenium.click("name=btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.click("name=ck0");
        selenium.click("name=rb0");
        selenium.click("name=btnGrabarMatricula");
        selenium.waitForPageToLoad("30000");
        assertEquals(selenium.getText("css=div.notice.success"), "Se registró su Matricula correctamente");
        /*
        listam2=mDAO.list();
        assertEquals(false,cmp(listam1,listam2));
                */
    }
    
    
    
    @Test
    public void SolicituddeAperturadeuncurso_Válido(){
        /*
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SolicitudDAO sDAO=context.getBean(SolicitudDAO.class);
        List<Solicitud> listas1=new ArrayList<Solicitud>();
        List<Solicitud> listas2=new ArrayList<Solicitud>();
        listas1=sDAO.list();
               */
        
        selenium.open("/MatriculaWeb/");
        selenium.type("name=txtUsuario", "cpalma");
        selenium.type("name=txtClave", "cesar");
        selenium.click("name=btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.click("name=btnSolicitarApertura");
        selenium.waitForPageToLoad("30000");
        selenium.select("name=CodigoCurso", "label=Arquitectura de Software");
        selenium.type("name=MotivoApertura", "Necesito llevar este curso");
        selenium.click("name=btnEnviarSolicitud");
        selenium.waitForPageToLoad("30000");
        assertEquals(selenium.getText("css=div.notice.success"), "Se envió la solicitud de Apertura de Curso!");
        /*
        listas2=sDAO.list();
        assertEquals(false,cmp2(listas1,listas2));*/
        
    }
    
    
    @Test
    public void SolicituddeAperturadeuncurso_Inválido(){
        /*
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SolicitudDAO sDAO=context.getBean(SolicitudDAO.class);
        List<Solicitud> listas1=new ArrayList<Solicitud>();
        List<Solicitud> listas2=new ArrayList<Solicitud>();
        listas1=sDAO.list();
               */
        
        selenium.open("/MatriculaWeb/");
        selenium.type("name=txtUsuario", "cpalma");
        selenium.type("name=txtClave", "cesar");
        selenium.click("name=btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.click("name=btnSolicitarApertura");
        selenium.waitForPageToLoad("30000");
        selenium.select("name=CodigoCurso", "label=Arquitectura de Software");
        selenium.click("name=btnEnviarSolicitud");
        selenium.waitForPageToLoad("30000");
        assertEquals(selenium.getText("css=div.notice.warning"), "La solicitud es invalida, seleccione un curso e ingrese un motivo");
        /*
        listas2=sDAO.list();
        assertEquals(false,cmp2(listas1,listas2));*/
        
    }
}
