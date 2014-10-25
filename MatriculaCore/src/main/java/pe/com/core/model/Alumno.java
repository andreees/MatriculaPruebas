
package pe.com.core.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author zcrome
 */
@Entity
@Table(name="ALUMNO")
public class Alumno {
    
    @Id
    @Column(name="idAlumno")
    private int idAlumno;
    
    private String nombres;
    private String apellidos;
    private int idUsuario;

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombres, String apellidos, int idUsuario) {
        this.idAlumno = idAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idUsuario = idUsuario;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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
        return "idAlumno="+idAlumno+", nombres="+nombres+", apellidos="+apellidos+", idusuario="+idUsuario;
    }
    
}
