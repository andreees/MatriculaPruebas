
package pe.com.core.model;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author zcrome
 */
@Entity
@Table(name="CLASE")
public class Clase {

    @Id
    @Column(name="idClase")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idClase;
    
    private String codigo;
    private String dia;
    private int horaInicio;
    private int horaFin;
    private String tipoClase;
    private int idSeccion;

    public Clase() {
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

     public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public String toString() {
       return "idClase="+idClase+", dia="+dia+", horaInicio="+horaInicio+", horaFin="+horaFin+", tipoClase="+tipoClase+", idSeccion="+idSeccion;
    }
    
}
