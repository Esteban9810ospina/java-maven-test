package com.quasar.frameq.estructura;

import com.quasar.frameq.db.*;
import java.util.Vector;
import java.sql.*;
import java.lang.*;
import java.sql.SQLException;
public class Ayuda extends Persistente {
	 private java.lang.Integer opcionmodulo ;
	 private java.lang.String ayuda ;
	 public Ayuda () {

		 this.setOpcionmodulo(new java.lang.Integer(0));
		 this.setAyuda(new java.lang.String(""));
	}
	 public Ayuda (  java.lang.Integer opcionmodulo, java.lang.String ayuda ) {
		 this.setOpcionmodulo( opcionmodulo );
		 this.setAyuda( ayuda );
	}
	 public void setOpcionmodulo(java.lang.Integer opcionmodulo){
		 this.opcionmodulo=opcionmodulo;
	}
	 public void setAyuda(java.lang.String ayuda){
		 this.ayuda=ayuda;
	}
	 public java.lang.Integer getOpcionmodulo(){
		 return opcionmodulo;
	}
	 public java.lang.String getAyuda(){
		 return ayuda;
	}
	 public Vector getContenido(){
		 Vector v = new Vector();
		 v.add(opcionmodulo);
		 v.add(ayuda);
		 return v;
	}
	 public void inicializar(){
		 setPersistente(this);
		 String atributos[]={"i_opcionmodulo","c_ayuda"};
		 int precision[]={0,0};
		 this.setPrecision(precision);
		 setAtributos(atributos);
		 setNombreTabla("fqs_ayuda");
		 setElementosLLave(1);
	}
	 public Persistente nuevo (Vector v){
		 return new Ayuda ((java.lang.Integer)v.elementAt(0),(java.lang.String)v.elementAt(1));
	}
	  public void setContenido() throws SQLException {
		 this.setOpcionmodulo(new Integer(rs.getInt("i_opcionmodulo")));
		 this.setAyuda((rs.getString("c_ayuda")));
	}
	 public void setContenido(Vector v)  {
		 this.setOpcionmodulo((Integer)v.elementAt(0));
		 this.setAyuda((String)v.elementAt(1));
	}
	 public boolean referencia(Vector v) {
		 return true;
	}
}
