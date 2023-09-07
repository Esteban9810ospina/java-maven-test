/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.interfaces;

/**
 *
 * @author jam
 */
public class Error {
    private int tipoError = 0;
    private int registro = 0;
    private int campo = 0;
    private String descripcion = "";
    private String linArchivo;
    public void setTipoError (int tipoError) {
      this.tipoError = tipoError;
    }
    public int getTipoError () {
      return this.tipoError;
    }
    public void setRegistro (int registro) {
      this.registro = registro;
    }
    public int getRegistro () {
      return this.registro;
    }
    public void setCampo (int campo) {
      this.campo = campo;
    }
    public int getCampo () {
      return this.campo;
    }
    public void setDescripcion (String descripcion) {
      this.descripcion = descripcion;
    }

    public void setLinArchivo(String linArchivo) {
        this.linArchivo = linArchivo;
    }

    public String getDescripcion () {
      return this.descripcion;
    }

    public String getLinArchivo() {
        return linArchivo;
    }

    public Error () {
      this.setTipoError(0);
      this.setRegistro(0);
      this.setCampo(0);
      this.descripcion = "";
      this.linArchivo = "";
    }

    public Error (int tipoError, String descripcion, int campo, int registro,
      String linArchivo) {
      this.setTipoError(tipoError);
      this.setRegistro(registro);
      this.setCampo(campo);
      this.setDescripcion(descripcion);
      this.setLinArchivo(linArchivo);
    }
}
