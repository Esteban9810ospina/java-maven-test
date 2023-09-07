/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.domain;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Roger Padilla C.
 */
public class Permiso implements Serializable {

  private static final long serialVersionUID = 126458081L;

  private Integer id;
  private Integer perfilId;
  private Calendar horaInicio;
  private Calendar horaFin;
  private String descripcion;
  private OpcionModulo opcionModulo;

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Calendar getHoraFin() {
    return horaFin;
  }

  public void setHoraFin(Calendar horaFin) {
    this.horaFin = horaFin;
  }

  public Calendar getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(Calendar horaInicio) {
    this.horaInicio = horaInicio;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPerfilId() {
    return perfilId;
  }

  public void setPerfilId(Integer perfilId) {
    this.perfilId = perfilId;
  }

  public OpcionModulo getOpcionModulo() {
    return opcionModulo;
  }

  public void setOpcionModulo(OpcionModulo opcionModulo) {
    this.opcionModulo = opcionModulo;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Permiso other = (Permiso) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    if (this.opcionModulo != other.opcionModulo && (this.opcionModulo == null || !this.opcionModulo.equals(other.opcionModulo))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 43 * hash + (this.opcionModulo != null ? this.opcionModulo.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "Permiso{" + "id=" + id + ", horaInicioPermiso=" + horaInicio + ", horaFinPermiso=" + horaFin + ", descripcion=" + descripcion + ", opcionModulo=" + opcionModulo + '}';
  }

}
