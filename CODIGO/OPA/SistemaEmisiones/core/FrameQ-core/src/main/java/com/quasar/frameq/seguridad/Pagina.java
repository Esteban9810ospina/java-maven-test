package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;

public class Pagina extends Persistente {

  private Integer codigoPagina;
  private String nombre;
  private String descripcion;

  public Pagina() {
    this.setCodigoPagina(new Integer(0));
    this.setNombre("");
    this.setDescripcion("");
  }

  public Pagina(Integer codigoPagina,String nombre,String descripcion) {
    this.setCodigoPagina(codigoPagina);
    this.setNombre(nombre);
    this.setDescripcion(descripcion);
  }
  
public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_codigopagina","c_nombre","c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_pagina");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new Pagina ((Integer)v.elementAt(0),(String)v.elementAt(1),
              (String)v.elementAt(2));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(codigoPagina);
    v.add(nombre);
    v.add(descripcion);
    return v;
  }

  public Integer getCodigoPagina() {
    return this.codigoPagina;
  }
  public String getNombre() {
    return this.nombre;
  }
  public String getDescripcion() {
    return this.descripcion;
  }

  public void setCodigoPagina(Integer codigoPagina) {
     this.codigoPagina = codigoPagina;
  }
  public void setNombre(String nombre) {
     this.nombre = nombre;
  }
  public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
  }

  public void setContenido() throws SQLException {
    this.setCodigoPagina(new Integer(rs.getInt("i_codigopagina")));
    this.setNombre((rs.getString("c_nombre")));
    this.setDescripcion((rs.getString("c_descripcion")));
  }

  public void setContenido(Vector v)   {
    String auxS = (String) v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if (auxI!=null) {
      this.setCodigoPagina(auxI );
    }
    else {
      this.setCodigoPagina(new Integer(0));
    }
    this.setNombre((String)v.elementAt(1) );
    this.setDescripcion((String)v.elementAt(2) );
  }

  public boolean referencia (Vector v){
    return true;
  }
}