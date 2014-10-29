package pe.com.core.model;

import javax.persistence.*;

@Entity
@Table(name="ADMINISTRADOR")
public class Administrador{
    
    @Id
    @Column(name="idAdministrador")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAdministrador;
    
    private String nombres;
    private String apellidos;
    private int idUsuario;

    public Administrador(int idAdministrador, String nombres, String apellidos, int idUsuario) {
        this.idAdministrador = idAdministrador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idUsuario = idUsuario;
    }

    public Administrador() {
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "idAdministrador="+idAdministrador+", nombres="+nombres+", apellidos="+apellidos+", idusuario="+idUsuario;
    }
    
    
    
    
}
