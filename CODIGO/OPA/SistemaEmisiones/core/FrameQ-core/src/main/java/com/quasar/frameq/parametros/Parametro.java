/* Static Model */
/*
 * Parametro
 *
 * Version:
 *
 * Date: 07 de November de 2002
 *
 * Author: Edison Tarquino
 *
 * Copyright Notice:
 */
package com.quasar.frameq.parametros;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;

public class Parametro extends Persistente {

  public Integer parametro;
  public String nombre;
  public Integer tipoDato;
  public String valor;
  public String descripcion;
  public String palabra;

  public Parametro() {
    setParametro(new Integer(0));
    setNombre("");
    setTipoDato(new Integer(0));
    setValor("");
    setDescripcion("");

  }

  public Parametro(Integer parametro, Integer tipoDato, String nombre,
          String valor, String descripcion) {
    setParametro(parametro);
    setNombre(nombre);
    setTipoDato(tipoDato);
    setValor(valor);
    setDescripcion(descripcion);
  }

  public Integer getParametro() {
    return parametro;
  }

  public void setParametro(Integer parametro) {
    this.parametro = parametro;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getTipoDato() {
    return tipoDato;
  }

  public void setTipoDato(Integer tipoDato) {
    this.tipoDato = tipoDato;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String setvalor) {
    this.valor = setvalor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Vector getContenido() {
    Vector v = new Vector();
    v.add(parametro);
    v.add(tipoDato);
    v.add(valor);
    v.add(descripcion);
    v.add(nombre);

    return v;
  }

  public void inicializar() {
    setPersistente(this);
    String atributos[] = {"i_parametro", "i_tipodato", "c_valor", "c_descripcion", "c_nombre"};

    setAtributos(atributos);
    setNombreTabla("fqs_parametro");
    setElementosLLave(1);
  }

  //** nuevo parametros Vector con atributos de GrupoMoneda
  public Persistente nuevo(Vector v) {
    return new Parametro((Integer) v.elementAt(0), (Integer) v.elementAt(1),
            (String) v.elementAt(2), (String) v.elementAt(3), (String) v.elementAt(4));
  }

  public void setContenido() throws SQLException {
    setParametro(new Integer(rs.getInt("i_parametro")));
    setNombre((rs.getString("c_nombre")));
    setTipoDato(new Integer(rs.getInt("i_tipodato")));
    setValor((rs.getString("c_valor")));
    setDescripcion((rs.getString("c_descripcion")));
  }

  public void setContenido(Vector v) {
    String auxS = (String) v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if (auxI != null) {
      this.setParametro(auxI);
    } else {
      this.setParametro(new Integer(0));
    }


    auxS = (String) v.elementAt(1);
    auxI = new Integer(auxS);
    if (auxI != null) {
      this.setTipoDato(auxI);
    } else {
      this.setTipoDato(new Integer(0));
    }

    setValor((String) v.elementAt(2));
    setDescripcion((String) v.elementAt(3));
    setNombre((String) v.elementAt(4));
  }

  public boolean referencia(Vector v) {
    return true;
  }
  
    public String setpalabra(String palabra) {
    return palabra;
  }
  
    public String getpalabra() {
    return palabra;
  }
}
