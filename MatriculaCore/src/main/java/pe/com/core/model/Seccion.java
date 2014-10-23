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

    /*
     public Seccion(int idSeccion, String codigo, String profesor) {
     this.idSeccion = idSeccion;
     this.codigo = codigo;
     this.profesor = profesor;
     }
     */
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
        return "idseccion=" + idSeccion + ", codigo=" + codigo;
    }

}
