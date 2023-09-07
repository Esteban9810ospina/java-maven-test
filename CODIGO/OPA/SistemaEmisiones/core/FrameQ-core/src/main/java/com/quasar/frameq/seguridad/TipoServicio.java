package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;

/**
 * <p>Title: SPIVI - TipoServicio</p>
 * <p>Description: Administración de registros de la tabla TipoServicio>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Quasar Software</p>
 * @author Diana Marcela Quiroga
 * @version 1.0a071102
 */

public class TipoServicio  extends Persistente {
  private Integer tipoServicio;
  private String nombre;
  private String descripcion;

  //** Constructores

  public TipoServicio() {
    setTipoServicio(new Integer(0));
    setNombre(new String ());
    setDescripcion(new String ());
  }

  public final Integer getTipoServicio(){
    return this.tipoServicio;
  }

  public void setTipoServicio(Integer setTipoServicio){
    this.tipoServicio = setTipoServicio;
  }

  public final String getNombre()	{
    return this.nombre;
  }

  public void setNombre(String setNombre)	{
    this.nombre = setNombre;
  }

  public final String getDescripcion(){
    return this.descripcion;
  }

  public void setDescripcion(String setDescripcion){
    this.descripcion = setDescripcion;
  }

  public TipoServicio(Integer tipoServicio,String nombre,String descripcion){
    setTipoServicio(tipoServicio);
    setNombre(nombre);
    setDescripcion(descripcion);
  }

  public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(tipoServicio);
    v.add(nombre);
    v.add(descripcion);
    return v;
  }

    public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_tiposervicio","c_nombre","c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_tiposervicio");
    setElementosLLave(1);
  }

   //** nuevo parametros Vector con atributos de valortasa
  public Persistente nuevo (Vector v)  {
    return new TipoServicio((Integer)v.elementAt(0),(String)v.elementAt(1),
      (String)v.elementAt(2));
  }

  public final void moduloSistema(){
  }

  public final void nombre(){
  }

  public final void descripcion(){
  }

  public void setContenido() throws SQLException {
    setTipoServicio(new Integer(rs.getInt("i_tiposervicio")));
    setNombre(new String (rs.getString("c_nombre")));
    setDescripcion(new String (rs.getString("c_descripcion")));
  }

  public void setContenido(Vector v) {
    String auxS = v.elementAt(0).toString();
    if (auxS != null)
      this.setTipoServicio(new Integer(auxS));
    else
      this.setTipoServicio(new Integer(0));
    this.setNombre(v.elementAt(1).toString());
    this.setDescripcion(v.elementAt(2).toString());
  }
  public boolean referencia(Vector v){
      return true;
    }
}
