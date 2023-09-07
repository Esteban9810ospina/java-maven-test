/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.estructura;

/**
 *
 * @author jam
 */
public class IpAutorizada {
    Integer ipUsuario =null;
    String ip=null;
    String usuarioSistema=null;
    String tipoModificacion=null;
    Integer id=null;



    public  IpAutorizada(){
        
    }
    public  IpAutorizada(Integer ipUsuario, String ip,String usuarioSistema,String tipoModificacion){
        if (ipUsuario != null) {
            this.ipUsuario = ipUsuario;
        }
        if (ip != null) {
            this.ip = ip;
        }
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
        }
        if (tipoModificacion != null) {
            this.tipoModificacion = tipoModificacion;
        }
        
    }

    public  IpAutorizada(Integer ipUsuario, String ip,String usuarioSistema,String tipoModificacion,Integer id){
        if (ipUsuario != null) {
            this.ipUsuario = ipUsuario;
        }
        if (ip != null) {
            this.ip = ip;
        }
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
        }
        if (tipoModificacion != null) {
            this.tipoModificacion = tipoModificacion;
        }
        if (id != null) {
            this.id = id;
        }
    }
    
    
    public void setIpUsuario(Integer ipUsuario){
        if (ipUsuario != null) {
            this.ipUsuario = ipUsuario;
        }
    }
    
    public Integer getIpUsuario() {
        return this.ipUsuario;
    }
    
    public void setIp(String ip){
        if (ip != null) {
            this.ip = ip;
        }
    }
    
    public String getIp(){
        return this.ip;
    }
    
    public void setUsuarioSistema (String usuarioSistema) {
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
        }
        
    }
    
    public String getUsuarioSistema() {
        return this.usuarioSistema;
    }
    
    public void setTipoModificacion(String tipoModificacion){
        if (tipoModificacion != null) {
            this.tipoModificacion = tipoModificacion;
        }        
    }
    
    public String getTipoModificacion() {
        return this.tipoModificacion;
    }
    public void setId(Integer id){
        if (id != null) {
            this.id = id;
        }
    }
    
    public Integer getId() {
        return this.id;
    }
    
}
