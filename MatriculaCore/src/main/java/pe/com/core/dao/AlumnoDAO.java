/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Alumno;

/**
 *
 * @author zcrome
 */
public interface AlumnoDAO {

	public void save(Alumno alumno);
	
	public List<Alumno> list();
        
        public boolean update(Alumno alumno);
        
        public boolean delete (Alumno alumno);
        
        public Alumno get(int id);
	
        public Alumno iniciarSesionAlumno(int codigoUsuario);
}
