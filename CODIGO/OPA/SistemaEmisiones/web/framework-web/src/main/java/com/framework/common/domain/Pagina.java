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
public class Pagina implements Serializable {

  private static final long serialVersionUID = 9106156982L;
  private Integer id;
  private String nombre;
  private String descripcion;
  private String subtitulo;

  public Pagina() {
  }

  public Pagina(Integer id, String nombre, String subtitulo) {
    this.id = id;
    this.nombre = nombre;
    this.subtitulo = subtitulo;
  }

  public String getSubtitulo() {
    return subtitulo;
  }

  public void setSubtitulo(String subtitulo) {
    this.subtitulo = subtitulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
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

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Pagina other = (Pagina) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 37 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "Pagina{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", subtitulo=" + subtitulo + '}';
  }
}
