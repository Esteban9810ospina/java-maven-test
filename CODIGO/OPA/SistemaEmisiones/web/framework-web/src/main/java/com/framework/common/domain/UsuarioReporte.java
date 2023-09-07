/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.framework.common.domain;

/**
 *
 * @author kgarcia_sophos
 */
public class UsuarioReporte {

    private static final long serialVersionUID = 82649870384L;

    private String username;

    private String estado;

    private String nombres;

    private String apellidos;

    private String email;

    private String telefono;

    private String perfil;

    private String scb;

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPerfil() {
        return this.perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getScb() {
        return this.scb;
    }

    public void setScb(String scb) {
        this.scb = scb;
    }

    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + ((this.username != null) ? this.username.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        com.framework.common.domain.UsuarioReporte other = (com.framework.common.domain.UsuarioReporte) obj;
        return !((this.username == null) ? (other.username != null) : !this.username.equals(other.username));
    }

}