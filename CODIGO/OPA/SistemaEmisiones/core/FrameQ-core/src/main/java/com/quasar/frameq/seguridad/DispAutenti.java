package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.SQLException;

/**
 * <p>Title: SPIVI - DispAutenti</p>
 * <p>Description: Administración de registros de la tabla DispAutenti>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Quasar Software</p>
 * @author Diana Marcela Quiroga
 * @version 1.0a081102
 */

public class DispAutenti  extends Persistente {
  private Integer dispAutenti;
  private String nombre;
  private String descripcion;

  //** Constructores

  public DispAutenti() {
    setDispAutenti(new Integer(0));
    setNombre(new String ());
    setDescripcion(new String ());
  }

  public final Integer getDispAutenti(){
    return this.dispAutenti;
  }

  public void setDispAutenti(Integer setDispAutenti){
    this.dispAutenti = setDispAutenti;
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

  public DispAutenti(Integer dispAutenti,String nombre,String descripcion){
    setDispAutenti(dispAutenti);
    setNombre(nombre);
    setDescripcion(descripcion);
  }

  public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(dispAutenti);
    v.add(nombre);
    v.add(descripcion);
    return v;
  }

    public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_dispautenti","c_nombre","c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_dispautenti");
    setElementosLLave(1);
  }

   //** nuevo parametros Vector con atributos de valortasa
  public Persistente nuevo (Vector v)  {
    return new DispAutenti((Integer)v.elementAt(0),(String)v.elementAt(1),
      (String)v.elementAt(2));
  }

  public final void moduloSistema(){
  }

  public final void nombre(){
  }

  public final void descripcion(){
  }

  public void setContenido() throws SQLException {
    setDispAutenti(new Integer(rs.getInt("i_dispautenti")));
    setNombre((rs.getString("c_nombre")));
    setDescripcion((rs.getString("c_descripcion")));
  }
  public void setContenido(Vector v)  {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setDispAutenti(auxI);
    else
      this.setDispAutenti(new Integer(0));

    this.setNombre((String)v.elementAt(1));
    this.setDescripcion((String)v.elementAt(2));
  }

    public boolean referencia(Vector v){
      return true;
    }
}


