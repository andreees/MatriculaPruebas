package pe.com.core.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pe.com.core.excel.Excel;
import pe.com.core.dao.CursoDAO;
import pe.com.core.model.Curso;

@Test
public class CursoTest {
    private Selenium selenium;
    
    @BeforeClass
    public void inicioClase() throws Exception{
        selenium = new DefaultSelenium("localhost", 4441, "firefox", 
                "http://localhost:8080/");
        selenium.start();
    }
        
    @Test(priority = 2)
    public void ListarCurso_Valido(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ListarCurso.jsp");
        selenium.waitForPageToLoad("30000");
        
        List<Curso> lista;
        lista=cursoDAO.list();

        Assert.assertTrue(lista!=null);
        
    }
    
    @Test(priority = 0)
    public void ListarCurso_Invalido(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ListarCurso.jsp");
        selenium.waitForPageToLoad("30000");
        
        List<Curso> lista;
        lista=cursoDAO.list();
        
        Assert.assertTrue(lista!=null && lista.size()==0);
        
    }
    
    @Test(priority = 1)
    public void CrearCurso_Valido(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        int cantidadDeCursosAlInicio,cantidadDeCursosAlFinal;
        
        List<Curso> lista;
        lista = new ArrayList<Curso>();
        lista=cursoDAO.list();
        cantidadDeCursosAlInicio = lista.size();
        
        //Leer de excel la data
        List<List<String>> data = new Excel().leer_CrearCurso();
        for(List<String> listainterna : data){
            selenium.open("/MatriculaWeb/index.jsp");
            selenium.type("txtUsuario", "epalomino");
            selenium.type("txtClave", "eduardo");
            selenium.click("btnIniciarSesion");
            selenium.waitForPageToLoad("30000");
            selenium.open("/MatriculaWeb/CrearCurso.jsp");
            selenium.type("txtNombre", listainterna.get(0));
            selenium.type("txtCodigo", listainterna.get(1));
            selenium.type("txtCreditos", listainterna.get(2));
            selenium.type("txtRequisitos", listainterna.get(3));
            selenium.type("txtCiclo", listainterna.get(4));
            selenium.click("btnCrearCurso");
            selenium.waitForPageToLoad("30000");
            
            cantidadDeCursosAlFinal = cursoDAO.list().size();
            Assert.assertTrue(cantidadDeCursosAlFinal>cantidadDeCursosAlInicio);
        }
    }
    
    @Test(priority = 3)
    public void CrearCurso_Invalido(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        int cantidadDeCursosAlInicio,cantidadDeCursosAlFinal;
        
        List<Curso> lista;
        lista = new ArrayList<Curso>();
        lista=cursoDAO.list();
        cantidadDeCursosAlInicio = lista.size();
                
        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/CrearCurso.jsp");
        selenium.type("txtNombre", "");
        selenium.type("txtCodigo", "25");
        selenium.type("txtCreditos", "dos");
        selenium.type("txtRequisitos", "IN32");
        selenium.type("txtCiclo", "SEXTO");
        selenium.click("btnCrearCurso");

        try{
            selenium.waitForPageToLoad("30000");
        }catch(com.thoughtworks.selenium.SeleniumException e)
        {
            if(e.getMessage().equalsIgnoreCase("Timed out after 30000ms"))
            {
                cantidadDeCursosAlFinal = cursoDAO.list().size();
                Assert.assertTrue(cantidadDeCursosAlFinal==cantidadDeCursosAlInicio);
                return;
            }
        }
        Assert.fail();
        
    }
    
    @Test(priority = 4)
    public void ModificarCurso_Valido(){
        
        //Leer de excel la data
        List<List<String>> data = new Excel().leer_ModificarCurso();
        for(List<String> listainterna : data){
            selenium.open("/MatriculaWeb/index.jsp");
            selenium.type("txtUsuario", "epalomino");
            selenium.type("txtClave", "eduardo");
            selenium.click("btnIniciarSesion");
            selenium.waitForPageToLoad("30000");
            selenium.open("/MatriculaWeb/ModificarCurso.jsp");
            selenium.click("linkModificarCurso");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtNombre", listainterna.get(0));
            selenium.type("txtCodigo", listainterna.get(1));
            selenium.type("txtCreditos", listainterna.get(2));
            selenium.type("txtRequisitos", listainterna.get(3));
            selenium.type("txtCiclo", listainterna.get(4));
            selenium.click("btnModificarCurso");
            selenium.waitForPageToLoad("30000");
            
            Assert.assertEquals(selenium.getText("lblMensaje"), "El curso ha sido modificado correctamente.");
        }
    }
    
    @Test(priority = 5)
    public void ModificarCurso_Invalido(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
        
        int cantidadDeCursosAlInicio,cantidadDeCursosAlFinal;
        
        List<Curso> lista;
        lista = new ArrayList<Curso>();
        lista=cursoDAO.list();
        cantidadDeCursosAlInicio = lista.size();
                
        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ModificarCurso.jsp");
        selenium.click("linkModificarCurso");
        selenium.waitForPageToLoad("30000");
        selenium.type("txtNombre", "NOMBRE");
        selenium.type("txtCodigo", "MD56");
        selenium.type("txtCreditos", "cincuenta");
        selenium.type("txtRequisitos", "");
        selenium.type("txtCiclo", "Decimo");
        selenium.click("btnModificarCurso");

        try{
            selenium.waitForPageToLoad("30000");
        }catch(com.thoughtworks.selenium.SeleniumException e)
        {
            if(e.getMessage().equalsIgnoreCase("Timed out after 30000ms"))
            {
                cantidadDeCursosAlFinal = cursoDAO.list().size();
                Assert.assertTrue(cantidadDeCursosAlFinal==cantidadDeCursosAlInicio);
                return;
            }
        }
        Assert.fail();
    }
    
//    @Test(priority = 6)
//    public void EliminarCurso_Valido(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//	CursoDAO cursoDAO = context.getBean(CursoDAO.class);
//        
//        int cantidadDeCursosAlInicio,cantidadDeCursosAlFinal;
//        
//        List<Curso> lista;
//        lista = new ArrayList<Curso>();
//        lista=cursoDAO.list();
//        cantidadDeCursosAlInicio = lista.size();
//        
//        selenium.open("/MatriculaWeb/index.jsp");
//        selenium.type("txtUsuario", "epalomino");
//        selenium.type("txtClave", "eduardo");
//        selenium.click("btnIniciarSesion");
//        selenium.waitForPageToLoad("30000");
//        selenium.open("/MatriculaWeb/EliminarCurso.jsp");
//        selenium.click("linkEliminarCurso");
//        selenium.waitForPageToLoad("30000");
//
//        cantidadDeCursosAlFinal = cursoDAO.list().size();
//        Assert.assertTrue(cantidadDeCursosAlFinal==cantidadDeCursosAlInicio-1);
//        
//    }
    
}
