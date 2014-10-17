/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Clase;

/**
 *
 * @author zcrome
 */
public interface ClaseDAO {

	public void save(Clase clase);
	
	public List<Clase> list();
        
        public boolean update(Clase clase);
        
        public boolean delete (Clase clase);
        
        public Clase get(int id);
	
}
