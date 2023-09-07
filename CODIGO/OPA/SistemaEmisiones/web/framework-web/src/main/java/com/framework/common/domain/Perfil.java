/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.domain;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Roger Padilla C.
 */
public class Perfil implements GrantedAuthority  {

  private static final long serialVersionUID = 1206750983L;

  private Integer id;
  private String authority;
  private boolean proceso;
  private List<OpcionModulo> opcionesModulo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getAuthority() {
    return this.authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public boolean isProceso() {
    return proceso;
  }

  public void setProceso(boolean proceso) {
    this.proceso = proceso;
  }

  public List<OpcionModulo> getOpcionesModulo() {
    return opcionesModulo;
  }

  public void addOpcionModulo(OpcionModulo opcionModulo) {
    opcionesModulo.add(opcionModulo);
  }

  public void setOpcionesModulo(List<OpcionModulo> opcionesModulo) {
    this.opcionesModulo = opcionesModulo;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Perfil other = (Perfil) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    if ((this.authority == null) ? (other.authority != null) : !this.authority.equals(other.authority)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 19 * hash + (this.authority != null ? this.authority.hashCode() : 0);
    return hash;
  }

  @Override
  public String toString() {
    return "Perfil{" + "id=" + id + ", nombre=" + authority + ", proceso=" + proceso + '}';
  }

}
