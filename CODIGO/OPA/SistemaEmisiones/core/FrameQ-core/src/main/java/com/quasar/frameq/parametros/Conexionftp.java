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

public class Conexionftp extends Persistente
{

    public Integer i_codigocon;
    public String c_ip;
    public String c_usuario;
     public String c_clave;
    public String c_ruta;
    public String c_descripcion;
    public String c_nombre;

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }

    public String getC_ip() {
        return c_ip;
    }

    public void setC_ip(String c_ip) {
        this.c_ip = c_ip;
    }

    public String getC_nombre() {
        return c_nombre;
    }

    public void setC_nombre(String c_nombre) {
        this.c_nombre = c_nombre;
    }
 public String getC_clave() {
        return c_clave;
    }

    public void setC_clave(String c_clave) {
        this.c_clave = c_clave;
    }
    public String getC_ruta() {
        return c_ruta;
    }

    public void setC_ruta(String c_ruta) {
        this.c_ruta = c_ruta;
    }

    public String getC_usuario() {
        return c_usuario;
    }

    public void setC_usuario(String c_usuario) {
        this.c_usuario = c_usuario;
    }

    public Integer getI_codigocon() {
        return i_codigocon;
    }

    public void setI_codigocon(Integer i_codigocon) {
        this.i_codigocon = i_codigocon;
    }

	public Conexionftp() {
	  setI_codigocon(new Integer(0));
	  setC_ip ("");
	  setC_usuario("");
          setC_clave("");
	  setC_ruta ("");
	  setC_descripcion ("");
          setC_nombre ("");
	}
	public Conexionftp(Integer codigo,String usuario,String ruta,
			 String nombre,String clave, String ip, String descripcion) {
	  setI_codigocon(codigo);
	  setC_usuario (usuario);
           setC_usuario (clave);
	  setC_ruta(ruta);
	  setC_nombre (nombre);
	  setC_ip(ip);
          setC_descripcion(descripcion);
	}

  public Vector getContenido ()  {
    Vector v= new Vector();
    v.add(i_codigocon);
    v.add(c_ip);
    v.add(c_usuario);
     v.add(c_clave);
    v.add(c_ruta);
    v.add(c_descripcion);
    v.add(c_nombre);
    return v;
  }

  public void inicializar ()  {
    setPersistente (this);
    String atributos []= {"i_codigocon","c_ip","c_usuario","c_clave","c_ruta","c_descripcion","c_nombre"};

    setAtributos(atributos);
    setNombreTabla("fqs_conexionftp");
    setElementosLLave(1);
  }

  //** nuevo parametros Vector con atributos de GrupoMoneda

  public Persistente nuevo (Vector v) {
    return new Conexionftp ((Integer)v.elementAt(0),(String)v.elementAt(1),
		  (String)v.elementAt(2),(String)v.elementAt(3),(String)v.elementAt(4)
            ,(String)v.elementAt(5),(String)v.elementAt(6));
  }

  public void setContenido() throws SQLException {
	  setI_codigocon(new Integer(rs.getInt("i_codigocon")));
	  setC_ip((rs.getString("c_ip")));
	  setC_usuario((rs.getString("c_usuario")));
          setC_clave((rs.getString("c_clave")));
	  setC_ruta((rs.getString("c_ruta")));
	  setC_descripcion((rs.getString("c_descripcion")));
          setC_nombre((rs.getString("c_nombre")));
  }
  public void setContenido(Vector v)  {
	  String auxS = (String)v.elementAt(0);
	  Integer auxI = new Integer(auxS);
	  if(auxI != null)
	    this.setI_codigocon(auxI);
	  else
	    this.setI_codigocon(new Integer(0));

	  setC_ip((String)v.elementAt(1));
	 

	  setC_usuario((String)v.elementAt(2));
           setC_clave((String)v.elementAt(3));
          setC_ruta((String)v.elementAt(4));
	  setC_descripcion((String)v.elementAt(5));
          setC_nombre((String)v.elementAt(6));
          
  }

    public boolean referencia(Vector v){
      return true;
    }


}