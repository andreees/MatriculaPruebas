/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pe.com.core.dao.ClaseDAO;
import pe.com.core.excel.Excel;
import pe.com.core.dao.SeccionDAO;
import pe.com.core.model.Clase;
import pe.com.core.model.Seccion;

/**
 *
 * @author Roy
 */
@Test
public class SeccionTest {

    private Selenium selenium;

    /*
    @BeforeClass
    public void inicioClase() throws Exception {
        selenium = new DefaultSelenium("localhost", 4441, "firefox",
                "http://localhost:8080/");
        selenium.start();
    }

    @Test
    public void ListarSeccion_Valido() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);

        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ListarSeccion.jsp");
        selenium.waitForPageToLoad("30000");

        List<Seccion> lista;
        lista = seccionDAO.list();

        Assert.assertTrue(lista != null);
    }

    @Test
    public void ListarSeccion_Invalido() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);

        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ListarSeccion.jsp");
        selenium.waitForPageToLoad("30000");

        List<Seccion> lista;
        lista = seccionDAO.list();

        Assert.assertTrue(lista != null && lista.size() == 0);
    }

    @Test
    public void CrearSeccion_Valido() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
        ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

        int cantidadDeSeccionesAlInicio, cantidadDeSeccionesAlFinal;
        int cantidadDeClasesAlInicio, cantidadDeClasesAlFinal;

        List<Seccion> listaSeccion;
        listaSeccion = new ArrayList<Seccion>();
        listaSeccion = seccionDAO.list();
        cantidadDeSeccionesAlInicio = listaSeccion.size();

        List<Clase> listaClase;
        listaClase = new ArrayList<Clase>();
        listaClase = claseDAO.list();
        cantidadDeClasesAlInicio = listaClase.size();

        //Leer de excel la data
        List<List<String>> data = new Excel().leer_CrearSeccion();
        for (List<String> listainterna : data) {
            selenium.open("/MatriculaWeb/index.jsp");
            selenium.type("txtUsuario", "epalomino");
            selenium.type("txtClave", "eduardo");
            selenium.click("btnIniciarSesion");
            selenium.waitForPageToLoad("30000");
            selenium.open("/MatriculaWeb/CrearSeccion.jsp");
            selenium.click("linkCrearSeccion");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtCodigoSeccion", listainterna.get(0));
            selenium.type("txtProfesor", listainterna.get(1));
            selenium.type("txtSalon", listainterna.get(2));
            selenium.type("cbDia", listainterna.get(3));//
            selenium.type("txtHoraInicio", listainterna.get(4));
            selenium.type("txtHoraFin", listainterna.get(5));
            selenium.type("cbTipoClase", listainterna.get(6));//
            selenium.click("btnCrearSeccion");
            selenium.waitForPageToLoad("30000");

            cantidadDeSeccionesAlFinal = seccionDAO.list().size();
            Assert.assertTrue(cantidadDeSeccionesAlFinal > cantidadDeSeccionesAlInicio);
            cantidadDeClasesAlFinal = claseDAO.list().size();
            Assert.assertTrue(cantidadDeClasesAlFinal > cantidadDeClasesAlInicio);
        }
    }

    @Test
    public void CrearCurso_Invalido() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
        ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

        int cantidadDeSeccionesAlInicio, cantidadDeSeccionesAlFinal;
        int cantidadDeClasesAlInicio, cantidadDeClasesAlFinal;

        List<Seccion> listaSeccion;
        listaSeccion = new ArrayList<Seccion>();
        listaSeccion = seccionDAO.list();
        cantidadDeSeccionesAlInicio = listaSeccion.size();

        List<Clase> listaClase;
        listaClase = new ArrayList<Clase>();
        listaClase = claseDAO.list();
        cantidadDeClasesAlInicio = listaClase.size();

        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/CrearSeccion.jsp");
        selenium.click("linkCrearSeccion");
        selenium.waitForPageToLoad("30000");
        selenium.type("txtCodigoSeccion", "MA291");
        selenium.type("txtProfesor", "David Mauricio");
        selenium.type("txtSalon", "H-54");
        selenium.type("cbDia", "Martes");//
        selenium.type("txtHoraInicio", "10");
        selenium.type("txtHoraFin", "12");
        selenium.type("cbTipoClase", "Teoria");//
        selenium.click("btnCrearSeccion");

        try {
            selenium.waitForPageToLoad("30000");
        } catch (com.thoughtworks.selenium.SeleniumException e) {
            if (e.getMessage().equalsIgnoreCase("Timed out after 30000ms")) {
                cantidadDeSeccionesAlFinal = seccionDAO.list().size();
                Assert.assertTrue(cantidadDeSeccionesAlFinal == cantidadDeSeccionesAlInicio);
                cantidadDeClasesAlFinal = claseDAO.list().size();
                Assert.assertTrue(cantidadDeClasesAlFinal == cantidadDeClasesAlInicio);
                return;
            }
        }
        Assert.fail();

    }

    @Test
    public void ModificarSeccion_Valido() {

        //Leer de excel la data
        List<List<String>> data = new Excel().leer_ModificarSeccion();
        for (List<String> listainterna : data) {
            selenium.open("/MatriculaWeb/index.jsp");
            selenium.type("txtUsuario", "epalomino");
            selenium.type("txtClave", "eduardo");
            selenium.click("btnIniciarSesion");
            selenium.waitForPageToLoad("30000");
            selenium.open("/MatriculaWeb/ModificarSeccion.jsp");
            selenium.click("linkModificarSeccionDeCurso");
            selenium.waitForPageToLoad("30000");
            selenium.click("linkModificarSeccion");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtCodigoSeccion", listainterna.get(0));
            selenium.type("txtProfesor", listainterna.get(1));
            selenium.type("txtSalon", listainterna.get(2));
            selenium.type("cbDia", listainterna.get(3));//
            selenium.type("txtHoraInicio", listainterna.get(4));
            selenium.type("txtHoraFin", listainterna.get(5));
            selenium.type("cbTipoClase", listainterna.get(6));//
            selenium.click("btnGuardarSeccion");
            selenium.waitForPageToLoad("30000");

            Assert.assertEquals(selenium.getText("mensajeConfirmacion"), "La seccion ha sido modificada correctamente.");
        }
    }

    @Test
    public void ModificarCurso_Invalido() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SeccionDAO seccionDAO = context.getBean(SeccionDAO.class);
        ClaseDAO claseDAO = context.getBean(ClaseDAO.class);

        int cantidadDeSeccionesAlInicio, cantidadDeSeccionesAlFinal;
        int cantidadDeClasesAlInicio, cantidadDeClasesAlFinal;

        List<Seccion> listaSeccions;
        listaSeccions = new ArrayList<Seccion>();
        listaSeccions = seccionDAO.list();
        cantidadDeSeccionesAlInicio = listaSeccions.size();

        List<Clase> listaClases;
        listaClases = new ArrayList<Clase>();
        listaClases = claseDAO.list();
        cantidadDeClasesAlInicio = listaClases.size();

        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/ModificarSeccion.jsp");
        selenium.click("linkModificarSeccionDeCurso");
        selenium.waitForPageToLoad("30000");
        selenium.click("linkModificarSeccion");
        selenium.waitForPageToLoad("30000");
        selenium.type("txtCodigoSeccion", "SEC001");
        selenium.type("txtProfesor", "MODIFICADO");
        selenium.type("txtSalon", "A-27");
        selenium.type("cbDia", "Lunes");//
        selenium.type("txtHoraInicio", "diez");
        selenium.type("txtHoraFin", "doce");
        selenium.type("cbTipoClase", "");//
        selenium.click("btnGuardarSeccion");
        selenium.waitForPageToLoad("30000");

        try {
            selenium.waitForPageToLoad("30000");
        } catch (com.thoughtworks.selenium.SeleniumException e) {
            if (e.getMessage().equalsIgnoreCase("Timed out after 30000ms")) {
                cantidadDeSeccionesAlFinal = seccionDAO.list().size();
                Assert.assertTrue(cantidadDeSeccionesAlFinal == cantidadDeSeccionesAlInicio);
                cantidadDeClasesAlFinal = claseDAO.list().size();
                Assert.assertTrue(cantidadDeClasesAlFinal == cantidadDeClasesAlInicio);
                return;
            }
        }
        Assert.fail();
    }

    @Test
    public void EliminarSeccion_Valido() {
        selenium.open("/MatriculaWeb/index.jsp");
        selenium.type("txtUsuario", "epalomino");
        selenium.type("txtClave", "eduardo");
        selenium.click("btnIniciarSesion");
        selenium.waitForPageToLoad("30000");
        selenium.open("/MatriculaWeb/EliminarSeccion.jsp");
        selenium.click("linkEliminarSeccionDeCurso");
        selenium.waitForPageToLoad("30000");
        selenium.click("lnkEliminarSeccion");
        selenium.waitForPageToLoad("30000");
        Assert.assertEquals(selenium.getText("mensajeConfirmacion"), "La seccion ha sido eliminada correctamente.");
    }
    */
}
