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

import java.util.Date;

/**
 *
 * @author zcrome
 */
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
