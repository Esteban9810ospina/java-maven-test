package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.util.Vector;
import java.sql.*;

public class TablaFuncion extends Persistente
{

        private Integer tablaFuncion;
	private Integer moduloSistema;
	private Integer opcionModulo;
	private String nombre;
	private String descripcion;

        public TablaFuncion() {
          this.setTablaFuncion(new Integer(0));
          this.setModuloSistema(new Integer(0));
          this.setOpcionModulo(new Integer(0));
          this.setNombre("");
          this.setDescripcion("");

	}

        public TablaFuncion(Integer tablaFuncion,Integer moduloSistema,
                            Integer opcionModulo,String nombre,String descripcion) {
          this.setTablaFuncion(tablaFuncion);
          this.setModuloSistema(moduloSistema);
          this.setOpcionModulo(opcionModulo);
          this.setNombre(nombre);
          this.setDescripcion(descripcion);

	}

public void inicializar ()  {
    setPersistente(this);
    String atributos[] = {"i_tablafuncion","i_modulosistema","i_opcionmodulo",
                          "c_nombre","c_descripcion"};

    setAtributos(atributos);
    setNombreTabla("fqs_tablafuncion");
    setElementosLLave(3);
  }

public Persistente nuevo (Vector v)  {
    return new TablaFuncion ((Integer)v.elementAt(0),(Integer)v.elementAt(1),
              (Integer)v.elementAt(2),(String)v.elementAt(3),(String)v.elementAt(4));
  }

public Vector getContenido ()  {
    Vector v = new Vector();
    v.add(tablaFuncion);
	v.add(moduloSistema);
	v.add(opcionModulo);
	v.add(nombre);
	v.add(descripcion);
    return v;
  }

	public final Integer getTablaFuncion()
	{
		return tablaFuncion;
	}
	public void setTablaFuncion(Integer tablaFuncion)
	{
		this.tablaFuncion = tablaFuncion;
	}
	public final Integer getModuloSistema()
	{
		return moduloSistema;
	}
	public void setModuloSistema(Integer moduloSistema)
	{
		this.moduloSistema = moduloSistema;
	}
	public final Integer getOpcionModulo()
	{
		return opcionModulo;
	}
	public void setOpcionModulo(Integer opcionModulo)
	{
		this.opcionModulo = opcionModulo;
	}
	public final String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public final String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public final void tablaFuncion()
	{

	}
	public final void moduloSistema()
	{

	}
	public final void opcionModulo()
	{

	}
	public final void nombre()
	{

	}
	public final void descripcion()
	{

	}

   public void setContenido() throws SQLException {
      this.setTablaFuncion(new Integer(rs.getInt("i_tablafuncion")));
      this.setModuloSistema(new Integer(rs.getInt("i_modulosistema")));
      this.setOpcionModulo(new Integer(rs.getInt("i_opcionmodulo")));
      this.setNombre((rs.getString("c_nombre")));
      this.setDescripcion((rs.getString("c_descripcion")));
   }

   public void setContenido(Vector v) {

      String auxS = (String)v.elementAt(0);
      Integer auxI = new Integer(auxS);
      if(auxI != null)
        this.setTablaFuncion(auxI);
      else
        this.setTablaFuncion(new Integer(0));

      auxS = (String)v.elementAt(1);
      auxI = new Integer(auxS);
      if(auxI != null)
        this.setModuloSistema(auxI);
      else
        this.setModuloSistema(new Integer(0));

      auxS = (String)v.elementAt(2);
      auxI = new Integer(auxS);
      if(auxI != null)
        this.setOpcionModulo(auxI);
      else
        this.setOpcionModulo(new Integer(0));
      this.setNombre((String)v.elementAt(3));
      this.setDescripcion((String)v.elementAt(4));
   }

   public boolean referencia(Vector v){
      return true;
    }
}