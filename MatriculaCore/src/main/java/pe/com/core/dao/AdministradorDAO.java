/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Administrador;

/**
 *
 * @author zcrome
 */
public interface AdministradorDAO {

	public void save(Administrador administrador);
	
	public List<Administrador> list();
        
        public boolean update(Administrador administrador);
        
        public boolean delete (Administrador administrador);
        
        public Administrador get(int id);
	
}
