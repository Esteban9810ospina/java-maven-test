package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.sql.*;
import java.util.Vector;

public class Servicio extends Persistente
{
  private Integer servicio;
  private Integer tipoServicio;
  private String nombre;
  private Double cantidadExistente;
  private String ubicacion;
  private String descripcion;

  public Servicio() {
    this.setServicio(new Integer(0));
    this.setTipoServicio(new Integer(0));
    this.setNombre("");
    this.setCantidadExistente(new Double(0.0));
    this.setUbicacion("");
    this.setDescripcion("");
  }

  public Servicio(Integer servicio,Integer tipoServicio,String nombre,Double cantidadExistente,
                  String ubicacion,String descripcion) {
    this.setServicio(servicio);
    this.setTipoServicio(tipoServicio);
    this.setNombre(nombre);
    this.setCantidadExistente(cantidadExistente);
    this.setUbicacion(ubicacion);
    this.setDescripcion(descripcion);
  }
  
public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_servicio","i_tiposervicio","c_nombre","e_cantexistente",
                          "c_ubicacion","c_descripcion"};

    setAtributos(atributos);
    int precision[]={0,0,0,3,0,0};
    setPrecision(precision);
    setNombreTabla("fqs_servicio");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new Servicio ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (String)v.elementAt(2),(Double)v.elementAt(3),(String)v.elementAt(4),
              (String)v.elementAt(5));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(servicio);
    v.add(tipoServicio);
    v.add(nombre);
    v.add(cantidadExistente);
    v.add(ubicacion);
    v.add(descripcion);
    return v;
  }

	public final Integer getServicio()
	{
		return servicio;
	}
	public void setServicio(Integer servicio)
	{
		this.servicio = servicio;
	}
	public final Integer getTipoServicio()
	{
		return tipoServicio;
	}
	public void setTipoServicio(Integer tipoServicio)
	{
		this.tipoServicio = tipoServicio;
	}
	public final String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public final Double getCantidadExistente()
	{
		return cantidadExistente;
	}
	public void setCantidadExistente(Double cantidadExistente)
	{
		this.cantidadExistente = cantidadExistente;
	}
	public final String getUbicacion()
	{
		return ubicacion;
	}
	public void setUbicacion(String ubicacion)
	{
		this.ubicacion = ubicacion;
	}
	public final String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
   public void setContenido() throws SQLException {
     this.setServicio(new Integer(rs.getInt("i_servicio")));
     this.setTipoServicio(new Integer(rs.getInt("i_tiposervicio")));
     this.setNombre((rs.getString("c_nombre")));
     this.setCantidadExistente(new Double(rs.getDouble("e_cantexistente")));
     this.setUbicacion((rs.getString("c_ubicacion")));
     this.setDescripcion((rs.getString("c_descripcion")));
   }

   public void setContenido(Vector v)  {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setServicio(auxI);
    else
      this.setServicio(new Integer(0));

    auxS = v.elementAt(1).toString();
    auxI = new Integer(auxS);
    if(auxI != null)
      this.setTipoServicio(auxI);
    else
      this.setTipoServicio(new Integer(0));

    this.setNombre((String)v.elementAt(2));
    auxS = v.elementAt(3).toString();
    Double auxD = new Double(auxS);
    if(auxD != null)
      this.setCantidadExistente(auxD);
    else
      this.setCantidadExistente(new Double(0.0));
    this.setUbicacion((String)v.elementAt(4));
    this.setDescripcion((String)v.elementAt(5));
  }

    public boolean referencia(Vector v){
      return true;
    }
}