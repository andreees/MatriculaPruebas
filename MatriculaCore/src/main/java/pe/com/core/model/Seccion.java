package pe.com.core.model;

import javax.persistence.*;

@Entity
@Table(name = "SECCION")
public class Seccion {

    @Id
    @Column(name = "idSeccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeccion;

    private String codigo;
    
    private String profesor;
    private int idcurso;

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public Seccion() {
    }

    public Seccion(int idSeccion, String codigo) {
        this.idSeccion = idSeccion;
        this.codigo = codigo;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
     public String getProfesor() {
     return profesor;
     }

     public void setProfesor(String profesor) {
     this.profesor = profesor;
     }
     

    @Override
    public String toString() {
        return "idseccion=" + idSeccion + ", codigo=" + codigo+ ", profesor=" + profesor;
    }

}
