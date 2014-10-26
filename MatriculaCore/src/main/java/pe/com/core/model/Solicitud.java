/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
