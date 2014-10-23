/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Seccion;

/**
 *
 * @author zcrome
 */
public interface SeccionDAO {

	public void save(Seccion seccion);
	
	public List<Seccion> list();
        
        public List<Seccion> listXIdCurso(int idCurso);
        
        public boolean update(Seccion seccion);
        
        public boolean delete (Seccion seccion);
        
        public Seccion get(int id);
	
}
