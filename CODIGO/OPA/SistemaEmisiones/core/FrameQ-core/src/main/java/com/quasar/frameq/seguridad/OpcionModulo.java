package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.sql.SQLException;
import java.util.Vector;

public class OpcionModulo extends Persistente {

  private Integer opcionModulo;
  private Integer codigoPagina;
  private Integer moduloSistema;
  private String nombre;
  private String descripcion;
  private Integer orden;
  private Integer opcionDepende;
  private Integer estado;

  public OpcionModulo() {
    setOpcionModulo(new Integer(0));
    setModuloSistema(new Integer(0));
    setCodigoPagina(new Integer(0));
    setNombre("");
    setDescripcion("");
    setOrden(new Integer(0));
    setOpcionDepende(new Integer(0));
    setEstado(new Integer(0));
  }

  public void setOpcionModulo(Integer setOpcionModulo) {
    this.opcionModulo = setOpcionModulo;
  }

  public void setModuloSistema(Integer modulosistema) {
    this.moduloSistema = modulosistema;
  }

  public void setCodigoPagina(Integer codigoPagina) {
    this.codigoPagina = codigoPagina;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String Descripcion) {
    this.descripcion = Descripcion;
  }

  public final Integer getOpcionModulo() {
    return this.opcionModulo;
  }

  public Integer getModuloSistema() {
    return this.moduloSistema;
  }

  public Integer getCodigoPagina() {
    return this.codigoPagina;
  }

  public final Integer getNombre() {
    return this.moduloSistema;
  }

  public final String getDescripcion() {
    return this.descripcion;
  }

  public Integer getOrden() {
    return this.orden;
  }

  public void setOrden(Integer orden) {
    this.orden = orden;
  }

  public Integer getOpcionDepende() {
    return this.opcionDepende;
  }

  public void setOpcionDepende(Integer opcionDepende) {
      if (opcionDepende.intValue()==0) {
          this.opcionDepende=null;
      }
      else {
          this.opcionDepende = opcionDepende;
      }
  }

  public Integer getEstado() {
    return this.estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
  }



  public OpcionModulo(Integer opcionModulo, Integer moduloSistema, Integer codigoPagina, String nombre, Integer orden, Integer opcionDepende, Integer estado, String descripcion) {
    setOpcionModulo(opcionModulo);
    setModuloSistema(moduloSistema);
    setCodigoPagina(codigoPagina);
    setNombre(nombre);
    setOrden(orden);
    setOpcionDepende(opcionDepende);
    setEstado(estado);
    setDescripcion(descripcion);
  }

  public Vector getContenido() {
    Vector v = new Vector();
    v.add(this.opcionModulo);
    v.add(this.moduloSistema);
    v.add(this.codigoPagina);
    v.add(this.nombre);
    v.add(this.orden);
    v.add(this.opcionDepende);
    v.add(this.estado);
    v.add(this.descripcion);
    return v;
  }

  public void inicializar() {
    setPersistente(this);
    String[] atributos = {"i_opcionmodulo", "i_modulosistema", "i_codigopagina", "c_nombre", "i_orden", "i_opciondepende", "i_estado",  "c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_opcionmodulo");
    setElementosLLave(1);
  }

  public Persistente nuevo(Vector v) {
    return new OpcionModulo((Integer) v.elementAt(0), (Integer) v.elementAt(1), (Integer) v.elementAt(2), (String) v.elementAt(3), (Integer) v.elementAt(4), (Integer) v.elementAt(5), (Integer) v.elementAt(6),  (String) v.elementAt(8));
  }

  public void setContenido()
          throws SQLException {
    setOpcionModulo(new Integer(this.rs.getInt("i_opcionmodulo")));
    setCodigoPagina(new Integer(this.rs.getInt("i_codigopagina")));
    setModuloSistema(new Integer(this.rs.getInt("i_modulosistema")));
    setNombre((this.rs.getString("c_nombre")));
    setDescripcion((this.rs.getString("c_descripcion")));
    setOrden(new Integer(this.rs.getInt("i_orden")));
    setOpcionDepende(new Integer(this.rs.getInt("i_opciondepende")));
    setEstado(new Integer(this.rs.getInt("i_estado")));
  }

  public void setContenido(Vector v) {
    String auxS = (String) v.elementAt(0);
    Integer auxI = new Integer(auxS);
    if (auxI != null) {
      setOpcionModulo(auxI);
    } else {
      setOpcionModulo(new Integer(0));
    }
    auxS = (String) v.elementAt(1);
    auxI = new Integer(auxS);
    if (auxI != null) {
      setModuloSistema(auxI);
    } else {
      setModuloSistema(new Integer(0));
    }

    auxS = (String) v.elementAt(2);
    auxI = new Integer(auxS);
    if (auxI != null) {
      setCodigoPagina(auxI);
    } else {
      setCodigoPagina(new Integer(0));
    }
    setNombre((String) v.elementAt(3));

    auxS = (String) v.elementAt(4);
    auxI = new Integer(auxS);
    if (auxI != null) {
      setOrden(auxI);
    } else {
      setOrden(new Integer(0));
    }

    auxS = (String) v.elementAt(5);
    auxI = new Integer(auxS);
    if (auxI != null) {
      setOpcionDepende(auxI);
    } else {
      setOpcionDepende(new Integer(0));
    }
    auxS = (String) v.elementAt(6);
    auxI = new Integer(auxS);
    if (auxI != null) {
      setEstado(auxI);
    } else {
      setEstado(new Integer(0));
    }

    setDescripcion((String) v.elementAt(7));
  }

  public boolean referencia(Vector v) {
    return true;
  }
}