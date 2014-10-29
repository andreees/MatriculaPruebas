package pe.com.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MATRICULA")
public class Matricula {
    
    @Id
    @Column(name="idMatricula")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idMatricula;
        
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechamatricula;
    
    private int horamatricula;
    private int idAlumno;
    private int idCurso;
    private int idSeccion;

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Matricula() {
    }

    public Matricula(int idMatricula, int horamatricula, Date fechamatricula, int idAlumno, int idCurso, int idSeccion) {
        this.idMatricula = idMatricula;
        this.horamatricula = horamatricula;
        this.fechamatricula = fechamatricula;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.idSeccion=idSeccion;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getHoramatricula() {
        return horamatricula;
    }

    public void setHoramatricula(int horamatricula) {
        this.horamatricula = horamatricula;
    }

    public Date getFechamatricula() {
        return fechamatricula;
    }

    public void setFechamatricula(Date fechamatricula) {
        this.fechamatricula = fechamatricula;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
       return "idMatricula="+idMatricula+", horamatricula="+horamatricula+", fechamatricula="+fechamatricula+", idcurso="+idCurso+", idalumno="+idAlumno+", idseccion="+idSeccion;
    }
        
    
    
    
}
