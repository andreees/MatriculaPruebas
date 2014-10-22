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
    
    @Test
    public void CrarCurso_Valido(){
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
    
}
