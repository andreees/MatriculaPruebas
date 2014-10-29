/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.web.matriculaweb.bean;

/**
 *
 * @author Roy
 */
public class UsuarioBean {
    private int idUsuario;
    private String privilegio;
    private int idAlumno;
    private int idAdministrador;
    private String usuarioLogin;
    private String nombres;
    private String apellidos;

    public UsuarioBean() {
    }

    public UsuarioBean(int idUsuario, String privilegio, int idAlumno, int idAdministrador, String usuarioLogin, String nombres, String apellidos) {
        this.idUsuario = idUsuario;
        this.privilegio = privilegio;
        this.idAlumno = idAlumno;
        this.idAdministrador = idAdministrador;
        this.usuarioLogin = usuarioLogin;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
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
}
