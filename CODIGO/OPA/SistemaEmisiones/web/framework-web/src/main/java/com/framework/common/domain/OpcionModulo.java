/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.domain;

import java.io.Serializable;

/**
 *
 * @author Roger Padilla C.
 */
public class OpcionModulo implements Serializable {

  private static final long serialVersionUID = 826483384L;
  private Integer id;
  private Integer perfilId;
  private String nombre;
  private String descripcion;
  private Integer orden;
  private Integer opcionDepende;
  private Integer estado;
  private Pagina pagina;
  private Integer ipagina;

  public OpcionModulo() {
  }

  public OpcionModulo(Integer id, Integer perfilId) {
    this.id = id;
    this.perfilId = perfilId;
  }

  public Integer getPerfilId() {
    return perfilId;
  }

  public void setPerfilId(Integer perfilId) {
    this.perfilId = perfilId;
  }

  public Pagina getPagina() {
    return pagina;
  }

  public void setPagina(Pagina pagina) {
    this.pagina = pagina;
  }


   public void setPagina(int ipagina) {
    this.ipagina = ipagina;
  }
  
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getOpcionDepende() {
    return opcionDepende;
  }

  public void setOpcionDepende(Integer opcionDepende) {
    this.opcionDepende = opcionDepende;
  }

  public Integer getOrden() {
    return orden;
  }

  public void setOrden(Integer orden) {
    this.orden = orden;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final OpcionModulo other = (OpcionModulo) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    if (this.perfilId != other.perfilId && (this.perfilId == null || !this.perfilId.equals(other.perfilId))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 83 * hash + (this.perfilId != null ? this.perfilId.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "OPA - OpcionModulo{" + "id=" + id + ", perfilId=" + perfilId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", orden=" + orden + ", opcionDepende=" + opcionDepende + ", estado=" + estado + ", pagina=" + pagina + '}';
  }
}
