/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.core.dao;
import java.util.List;
import pe.com.core.model.Solicitud;

/**
 *
 * @author zcrome
 */
public interface SolicitudDAO {

	public void save(Solicitud solicitud);
	
	public List<Solicitud> list();
        
        public boolean update(Solicitud solicitud);
        
        public boolean delete (Solicitud solicitud);
        
        public Solicitud get(int id);
	
}
