package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;



public class Perfil extends Persistente
{
  private Integer perfil;
  private String nombre;
  private String horaInicioSesion;
  private String horaFinSesion;
  private String descripcion;

  public Perfil()	{
   this.setperfil(new Integer(0));
   this.setnombre("");
   this.sethoraInicioSesion("");
   this.sethoraFinSesion("");
   this.setdescripcion("");
  }

  public Perfil(Integer perfil,String nombre,String horaInicioSesion,String horaFinSesion,
               String descripcion) {
    this.setperfil(perfil);
    this.setnombre(nombre);
    this.sethoraInicioSesion(horaInicioSesion);
    this.sethoraFinSesion(horaFinSesion);
    this.setdescripcion(descripcion);
  }
public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_perfil","c_nombre","dt_horainisesion","dt_horafinsesion",
                          "c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_perfil");
    setElementosLLave(1);
  }

public Persistente nuevo (Vector v)  {
    return new Perfil ((Integer)v.elementAt(0),(String)v.elementAt(1),
              (String)v.elementAt(2),(String)v.elementAt(3),
              (String)v.elementAt(4));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(  perfil);
    v.add(  nombre);
    v.add( horaInicioSesion);
    v.add( horaFinSesion);
    v.add( descripcion);
    return v;
  }

public Integer getPerfil() {
		return perfil;
	}
	public void setperfil(Integer setperfil) {
		perfil = setperfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setnombre(String setnombre)	{
		nombre = setnombre;
	}
	public String getHoraInicioSesion() {
		return horaInicioSesion;
	}
	public void sethoraInicioSesion(String sethoraInicioSesion) {
		horaInicioSesion = sethoraInicioSesion;
	}
	public String getHoraFinSesion() {
		return horaFinSesion;
	}
	public void sethoraFinSesion(String sethoraFinSesion) {
		horaFinSesion = sethoraFinSesion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setdescripcion(String setdescripcion) {
		descripcion = setdescripcion;
	}
   public void setContenido() throws SQLException {
     this.setperfil(new Integer(rs.getInt("i_perfil")));
     this.setnombre((rs.getString("c_nombre")));
     this.sethoraInicioSesion((rs.getString("dt_horainisesion")));
     this.sethoraFinSesion((rs.getString("dt_horafinsesion")));
     this.setdescripcion((rs.getString("c_descripcion")));
   }

   public void setContenido(Vector v)  {

    String auxS = v.elementAt(0).toString();
    Integer auxI = new Integer(auxS);
    if(auxI != null)
      this.setperfil(auxI);
    else
      this.setperfil(new Integer(0));

    this.setnombre((String)v.elementAt(1));

    this.sethoraInicioSesion((String)v.elementAt(2));
    this.sethoraFinSesion((String)v.elementAt(3));
    this.setdescripcion((String)v.elementAt(4));
  }

    public boolean referencia(Vector v){
      return true;
    }
}


