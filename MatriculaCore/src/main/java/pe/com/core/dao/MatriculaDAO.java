/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Matricula;

/**
 *
 * @author zcrome
 */
public interface MatriculaDAO {

	public void save(Matricula matricula);
	
	public List<Matricula> list();
        
        public boolean update(Matricula matricula);
        
        public boolean delete (Matricula matricula);
        
        public Matricula get(int id);
	
}
