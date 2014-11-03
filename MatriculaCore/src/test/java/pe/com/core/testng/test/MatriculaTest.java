/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.testng.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import pe.com.core.dao.MatriculaDAO;
//import pe.com.core.model.Matricula;

/**
 *
 * @author Cesar
 */
public class MatriculaTest {
    /*
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private MatriculaDAO matriculaDAO;

    

   //al inicio de la clase
     @BeforeClass
     public static void inicioClase(){
         
         System.out.println("Inicio de la clase");
        
     }

     //al final de la clase
     @AfterClass
     public static void finClase(){
         System.out.println("Final de la Clase");
     }
     
     @Test
     public void saveCorrectoTest(){
        try {
            matriculaDAO=context.getBean(MatriculaDAO.class);
            
            Matricula matricula=new Matricula(); 
            matricula.setFechamatricula(DateTime.now().toDate());
            matricula.setHoramatricula(DateTime.now().getHourOfDay());
            matricula.setIdAlumno(1);
            matricula.setIdCurso(1);
            matricula.setIdSeccion(1);
            matricula.setIdMatricula(0);
            matriculaDAO.save(matricula);
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            //matriculaDAO=context.getBean(MatriculaDAO.class);
            List<Matricula> Lista = new ArrayList<Matricula>();
            Lista=matriculaDAO.list();
            Matricula matricula2=Lista.get(Lista.size()-1);
            Assert.assertEquals(matricula2.getFechamatricula().toString(),format.format(matricula.getFechamatricula()));
            Assert.assertEquals(matricula2.getHoramatricula(),matricula.getHoramatricula());
            Assert.assertEquals(matricula2.getIdAlumno(),matricula.getIdAlumno());
            Assert.assertEquals(matricula2.getIdCurso(),matricula.getIdCurso());
            Assert.assertEquals(matricula2.getIdSeccion(),matricula.getIdSeccion());
            Assert.assertEquals(matricula2.getIdMatricula(),matricula.getIdMatricula());
            
            
        } catch (Exception e) {
             e.printStackTrace();
             Assert.fail("Fallo "+e.getMessage());
        }
     }
     
     @Test
     public void saveIncorrectoTest(){
        try {
            matriculaDAO=context.getBean(MatriculaDAO.class);
            
            
            System.out.println("Metodo save");
            Matricula matricula=new Matricula(); 
            matricula.setFechamatricula(DateTime.now().toDate());
            matricula.setHoramatricula(DateTime.now().getHourOfDay());
            matricula.setIdAlumno(1);
            matricula.setIdCurso(1);
            matriculaDAO.save(matricula);
            
            Assert.assertEquals(matricula.getIdMatricula(),0);
            
        } catch (Exception e) {
             e.printStackTrace();
             Assert.fail("Fallo "+e.getMessage());
        }
     }
    */
}
