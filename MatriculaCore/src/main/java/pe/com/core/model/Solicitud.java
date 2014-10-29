
package pe.com.core.model;

import javax.persistence.*;

@Entity
@Table(name="SOLICITUD")
public class Solicitud {

    @Id
    @Column(name="idSolicitud")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idSolicitud;
    
    private String motivo;
    private int idAlumno;
    private int idCurso;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Solicitud() {
    }

    public Solicitud(int idSolicitud, String motivo, int idAlumno,int idCurso) {
        this.idSolicitud = idSolicitud;
        this.motivo = motivo;
        this.idAlumno = idAlumno;
        this.idCurso=idCurso;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    @Override
    public String toString() {
       return "idSolicitud="+idSolicitud+", motivo="+motivo+", idAlumno="+idAlumno+", idCurso="+idCurso;
    }
    
}
