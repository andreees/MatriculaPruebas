
package pe.com.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="USUARIO")
public class Usuario {
    
    @Id
    @Column(name="idUsuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;
    
    private String usuario;
    private String clave;
    

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String clave) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString() {
       return "idUsuario="+idUsuario+", usuario="+usuario+", clave="+clave;
    }
}
