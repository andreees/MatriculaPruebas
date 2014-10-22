/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Usuario;

/**
 *
 * @author zcrome
 */
public interface UsuarioDAO {

	public void save(Usuario usuario);
	
	public List<Usuario> list();
        
        public boolean update(Usuario usuario);
        
        public boolean delete (Usuario usuario);
        
        public Usuario get(int id);
	
        public Usuario iniciarSesion(String pUsuario, String pClave);
}
