

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.com.core.dao.SeccionDAO;
import pe.com.core.model.Seccion;

import pe.com.core.dao.CursoDAO;
import pe.com.core.model.Curso;

import pe.com.core.dao.ClaseDAO;
import pe.com.core.model.Clase;

import pe.com.core.dao.UsuarioDAO;
import pe.com.core.model.Usuario;
import pe.com.core.dao.AlumnoDAO;
import pe.com.core.model.Alumno;
import pe.com.core.dao.AdministradorDAO;
import pe.com.core.model.Administrador;

import pe.com.core.dao.SolicitudDAO;
import pe.com.core.model.Solicitud;

import pe.com.core.dao.MatriculaDAO;
import pe.com.core.model.Matricula;


public class test {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
                MatriculaDAO dao = context.getBean(MatriculaDAO.class);
                
                
                Matricula matricula = new Matricula();
                
                matricula.setHoramatricula(15);
                matricula.setFechamatricula(null);
                matricula.setIdCurso(1);
                matricula.setIdAlumno(1);
                
                dao.save(matricula);
                
                
                
                
                
                
                
                /*
                Solicitud solicitud = new Solicitud();
                
                solicitud.setMotivo("Logramos tener 30 firmas para OpenSource");
                solicitud.setIdAlumno(1);
                
                dao.save(solicitud);
                
                
                
                
                
                /*
		UsuarioDAO daoUsuario = context.getBean(UsuarioDAO.class);
                AlumnoDAO daoAlumno = context.getBean(AlumnoDAO.class);
                AdministradorDAO daoAdministrador = context.getBean(AdministradorDAO.class);
                
                
                Usuario usuario = new Usuario();
                usuario.setUsuario("admin");
                usuario.setClave("admin");
                
                daoUsuario.save(usuario);
                 
                Administrador administrador = new Administrador();
                administrador.setNombres("will");
                administrador.setApellidos("strike");
                administrador.setIdUsuario(1);                
               
                daoAdministrador.save(administrador);
                
                
                Usuario usuario2 = new Usuario();
                usuario.setUsuario("u201012721");
                usuario.setClave("123");
                
                daoUsuario.save(usuario2);
                
                Alumno alumno = new Alumno();
                alumno.setNombres("zcrome");
                alumno.setApellidos("rock");
                alumno.setIdUsuario(2);
                
                daoAlumno.save(alumno);
                */
                
                
                
                
                
		/*
		Seccion sec = new Seccion();
		sec.setCodigo("CDW");
                sec.setProfesor("profe");
		
		s.save(sec);
		
		System.out.println("Seccion::"+sec);
		
		List<Seccion> list = s.list();
		
		for(Seccion p : list){
			System.out.println("Person List::"+p);
		}
		*/       
             
                /*
                Clase clase =  new Clase();                
                clase.setDia(1);
                clase.setHoraInicio(13);
                clase.setHoraFin(15);
                clase.setTipoClase("TEORIA");
                clase.setIdCurso(1);
                clase.setIdSeccion(1);
                
                dao.save(clase);
                */
                
                
                
                
		context.close();
		
	}

}