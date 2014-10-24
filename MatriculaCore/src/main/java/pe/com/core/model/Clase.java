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
/*
    public Clase(int idClase, String dia, int horaInicio, int horaFin, String tipoClase, int idSeccion) {
        this.idClase = idClase;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoClase = tipoClase;
        this.idSeccion = idSeccion;
    }
*/
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
